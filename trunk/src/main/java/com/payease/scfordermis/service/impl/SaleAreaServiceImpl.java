package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqSaveSellAreaBean;
import com.payease.scfordermis.bo.responseBo.RespAreaListBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.dao.AreaInfoDao;
import com.payease.scfordermis.entity.TAreaInfoEntity;
import com.payease.scfordermis.service.SaleAreaService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 首页-客户-销售区域
 * @Created By liuxiaoming
 * @CreateTime 2018/1/17 下午2:22
 **/
@Service
public class SaleAreaServiceImpl implements SaleAreaService {

    private static final Logger log = LoggerFactory.getLogger(SaleAreaServiceImpl.class);

    @Autowired
    private AreaInfoDao areaInfoDao;
    /**
     * 区域列表接口
     * @param session
     * @return
     */
    @Override
    public ResultBo arealist(HttpSession session) throws Exception{
        ResultBo result = ResultBo.build();

        try{
            //从session中取 Long fCompanyId
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null){ return result.timeOut();}
            Long fCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");

        //一级销售区域集合
        List<TAreaInfoEntity> OneList = areaInfoDao.findByFLevelAndFCompanyId("1", fCompanyId);
        //二级销售区域集合
        List<TAreaInfoEntity> TwoList = areaInfoDao.findByFLevelAndFCompanyId("2",fCompanyId);

        //总集合
        List<RespAreaListBean> FUlist = new ArrayList<>();
        //循环一级销售区域集合
        for (TAreaInfoEntity one : OneList){

            List<RespAreaListBean> ZIlist = new ArrayList<>();
            //循环二级销售区域集合
            for (TAreaInfoEntity two : TwoList){
                //找到一级销售区域的子集合
                if(two.getfParentId() == one.getfId()){
                    RespAreaListBean resp2 = new RespAreaListBean();
                    resp2.setfId(two.getfId());
                    resp2.setfName(two.getfName());
                    resp2.setfParentId(two.getfParentId());
                    //将二级销售区域放入子集合
                    ZIlist.add(resp2);
                }
            }

            RespAreaListBean resp1 = new RespAreaListBean();
            resp1.setfId(one.getfId());
            resp1.setfName(one.getfName());
            resp1.setfParentId(one.getfParentId());
            resp1.setChildList(ZIlist);
            //将一级销售区域放入父集合
            FUlist.add(resp1);
        }
        result.setResultBody(FUlist);
    }catch (Exception e){
        e.printStackTrace();
        result.fail();
        log.error("SaleAreaService - - arealist :",e);
        throw e;
    }
        return result;
    }
    /**
     * 新增修改区域接口
     *  @ApiModelProperty(value = "主键ID（新增：ID非必填 修改：ID必填）",dataType = "long")
            private Long fId;
        @ApiModelProperty(value = "上级销售区域ID（新增父节点：ParentId非必填 新增子节点：ParentId必填）",dataType = "long")
            private Long fParentId;
        @ApiModelProperty(value = "销售区域名称",dataType = "string",required = true)
            private String Name;
     * @param session
     * @return
     */
    @Override
    public ResultBo save(HttpSession session, ReqSaveSellAreaBean req) throws Exception{
        ResultBo result = ResultBo.build();
        try{
            if(req == null || StringUtils.isBlank(req.getfName())){return result.queryError();}

            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null || sessionInfo.getfId() == null){
                return result.timeOut();
            }

            //  Long fCompanyId
            Long fCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");
            //  Long sessionId
            Long sessionId = sessionInfo.getfId();//Long.valueOf("1");


        //检验地区名称是否重复
        if(req.getfParentId() != null && req.getfParentId() == 0){
            //一级名称不能重复
            if(areaInfoDao.countByFNameAndFLevelAndFCompanyId(req.getfName(),"1",fCompanyId)!=0){
                log.error("SaleAreaService - - save :"+Status.AREAONEREPEAT.getMessage());
                return result.setCodeId(Status.AREAONEREPEAT);
            }
        }else{
            //同一父级的二级名称不能重复
            if(areaInfoDao.countByFNameAndFLevelAndFParentIdAndFCompanyId(req.getfName(),"2",req.getfParentId(),fCompanyId)!=0){
                //地区名称重复
                log.error("SaleAreaService - - save :"+Status.AREAREPEAT.getMessage());
                return result.setCodeId(Status.AREAREPEAT);
            }
        }

        TAreaInfoEntity entity = new TAreaInfoEntity();
        if(req == null){return result.fail();}
        if(req.getfId() != null){
            //修改
            entity = areaInfoDao.findOne(req.getfId());
            if(entity == null){
                //未查询到该地区
                log.error("SaleAreaService - - save :"+Status.GETAREA.getMessage());
                return result.setCodeId(Status.GETAREA);
            }
        }else{
            //新增
            if(req.getfParentId() != null){
                if (req.getfParentId() == 0) {
                    //新增父节点
                    entity.setfLevel("1");
                } else {
                    //新增子节点
                    entity.setfLevel("2");
                }
            } else{
                return result.queryError();
            }
            entity.setfCode("0");
            entity.setfCreateTime(new Date());//新增时间
            if(req.getfParentId()!=null){
                entity.setfParentId(req.getfParentId());
            }
        }
        entity.setfUpdateTime(new Date()); //修改时间
        entity.setfName(req.getfName());//销售区域名称
        entity.setfOperate(sessionId);//操作人
        entity.setfCompanyId(fCompanyId);//公司ID
        areaInfoDao.save(entity);
    }catch (Exception e){
        e.printStackTrace();
        result.fail();
        log.error("SaleAreaService - - save :",e);
        throw e;
    }
        return result;
    }
    /**
     * 删除区域接口
     * @param session
     * @return
     */
    @Override
    public ResultBo delete(HttpSession session, Long Id) throws Exception{
        ResultBo result = ResultBo.build();

        try{
        if(Id == null){return result.queryError();}
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null){
                return result.timeOut();
            }

            //  Long fCompanyId
            Long fCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");


        TAreaInfoEntity one = areaInfoDao.findOne(Id);

        if(one == null){
            //未查询到该地区
            log.error("SaleAreaService - - delete :"+Status.GETAREA.getMessage());
            return result.setCodeId(Status.GETAREA);
        }


        //查看该销售区域是几级销售区域
        if(one.getfLevel().equals("1")){
            //一级销售区域：查看该销售区域是否含有子销售区域
            if(areaInfoDao.countByFParentIdAndFCompanyId(one.getfId(),fCompanyId) != 0){
                //该销售区域含有子销售区域
                log.error("SaleAreaService - - delete :"+Status.AREAONEISTWO.getMessage());
                return result.setCodeId(Status.AREAONEISTWO);
            }
        }
        areaInfoDao.delete(one);
    }catch (Exception e){
        e.printStackTrace();
        result.fail();
        log.error("SaleAreaService - - delete :",e);
        throw e;
    }
        return result;
    }
}
