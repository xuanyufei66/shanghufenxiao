package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqSaveDepSetBean;
import com.payease.scfordermis.bo.responseBo.RespDepSetListBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.dao.DepartmentInfoDao;
import com.payease.scfordermis.entity.TDepartmentInfoEntity;
import com.payease.scfordermis.service.DepSetService;
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
 * 首页-设置-部门设置
 * @Created By liuxiaoming
 * @CreateTime 2018/1/17 下午2:22
 **/
@Service
public class DepSetServiceImpl implements DepSetService {

    private static final Logger log = LoggerFactory.getLogger(DepSetServiceImpl.class);

    @Autowired
    private DepartmentInfoDao departmentInfoDao;
    /**
     * 部门列表接口
     * @param session
     * @return
     */
    @Override
    public ResultBo deplist(HttpSession session) throws Exception {
        ResultBo result = ResultBo.build();

        try{
            //从session中取 Long fCompanyId
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null){ return result.timeOut();}
            Long fCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");
        //一级部门集合
        List<TDepartmentInfoEntity> depOneList = departmentInfoDao.findByFLevelAndFCompanyId("1", fCompanyId);
        //二级部门集合
        List<TDepartmentInfoEntity> depTwoList = departmentInfoDao.findByFLevelAndFCompanyId("2",fCompanyId);

        //总集合
        List<RespDepSetListBean> FUlist = new ArrayList<>();
        //循环一级部门集合
        for (TDepartmentInfoEntity one : depOneList){

            List<RespDepSetListBean> ZIlist = new ArrayList<>();
            //循环二级部门集合
            for (TDepartmentInfoEntity two : depTwoList){
                //找到一级部门的子集合
                if(two.getfParentId() == one.getfId()){
                    RespDepSetListBean resp2 = new RespDepSetListBean();
                    resp2.setfId(two.getfId());
                    resp2.setfName(two.getfName());
                    resp2.setfParentId(two.getfParentId());
                    //将二级部门放入子集合
                    ZIlist.add(resp2);
                }
            }

            RespDepSetListBean resp1 = new RespDepSetListBean();
            resp1.setfId(one.getfId());
            resp1.setfName(one.getfName());
            resp1.setfParentId(one.getfParentId());
            resp1.setChildList(ZIlist);
            //将一级部门放入父集合
            FUlist.add(resp1);
        }
        result.setResultBody(FUlist);


        }catch (Exception e){
            e.printStackTrace();
            result.fail();
            log.error("DepSetService - - deplist :",e);
            throw e;
        }
        return result;

    }
    /**
     * 新增修改接口
     *  @ApiModelProperty(value = "主键ID（新增：ID非必填 修改：ID必填）",dataType = "long")
            private Long fId;
        @ApiModelProperty(value = "上级部门ID（新增父节点：ParentId非必填 新增子节点：ParentId必填）",dataType = "long")
            private Long fParentId;
        @ApiModelProperty(value = "部门名称",dataType = "string",required = true)
            private String depName;
     * @param session
     * @return
     */
    @Override
    public ResultBo save(HttpSession session, ReqSaveDepSetBean req) throws Exception{
        ResultBo result = ResultBo.build();

        try {
            if (req == null || StringUtils.isBlank(req.getDepName())) {
                return result.queryError();
            }
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null || sessionInfo.getfId() == null){
                return result.timeOut();
            }
            //  Long fCompanyId
            Long fCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");
            //  Long sessionId
            Long sessionId = sessionInfo.getfId();//Long.valueOf("1");

            //检验部门名称是否重复
            if (req.getfParentId() != null && req.getfParentId() == 0) {
                //一级名称不能重复
                if (departmentInfoDao.countByFNameAndFLevelAndFCompanyId(req.getDepName(), "1",fCompanyId) != 0) {
                    log.error("DepSetService - - save :"+Status.DEPONEREPEAT.getMessage());
                    return result.setCodeId(Status.DEPONEREPEAT);
                }
            } else {
                //同一父级的二级名称不能重复
                if (departmentInfoDao.countByFNameAndFLevelAndFParentIdAndFCompanyId(req.getDepName(), "2", req.getfParentId(),fCompanyId) != 0) {
                    result.fail();
                    result.setMessage("部门名称重复");
                    log.error("DepSetService - - save :"+Status.DEPREPEAT.getMessage());
                    return result.setCodeId(Status.DEPREPEAT);
                }
            }
            TDepartmentInfoEntity entity = new TDepartmentInfoEntity();

            if (req.getfId() != null) {
                //修改
                entity = departmentInfoDao.findOne(req.getfId());
                if (entity == null) {
                    //未查询到该部门
                    log.error("DepSetService - - save :"+Status.GETDEP.getMessage());
                    return result.setCodeId(Status.GETDEP);
                }
            } else {
                //新增
                if(req.getfParentId() == null){
                    return result.queryError();
                } else{
                    if (req.getfParentId() == 0) {
                        //新增父节点
                        entity.setfLevel("1");
                    } else {
                        //新增子节点
                        entity.setfLevel("2");
                    }
                }
                entity.setfCreate(sessionId);//创建人
                entity.setfCreateTime(new Date());//新增时间
                if (req.getfParentId() != null) {
                    entity.setfParentId(req.getfParentId());
                }
            }
            entity.setfUpdateTime(new Date()); //修改时间
            entity.setfName(req.getDepName());//部门名称
            entity.setfOperate(sessionId);//操作人
            entity.setfCompanyId(fCompanyId);//公司ID
            departmentInfoDao.save(entity);
        }catch (Exception e){
            e.printStackTrace();
            result.fail();
            log.error("DepSetService - - save :",e);
            throw e;
        }
        return result;
    }
    /**
     * 删除接口
     * @param session
     * @return
     */
    @Override
    public ResultBo delete(HttpSession session, Long depId) throws Exception{

        ResultBo result = ResultBo.build();

        try{
        if(depId == null){return result.queryError();}

            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null){ return result.timeOut();}
            Long fCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");
        TDepartmentInfoEntity one = departmentInfoDao.findOne(depId);

        if(one == null){
            //未查询到该部门
            log.error("DepSetService - - delete :"+Status.GETDEP.getMessage());
            return  result.setCodeId(Status.GETDEP);
        }
        //查看该部门是几级部门
        if(one.getfLevel().equals("1")){
            //一级部门：查看该部门是否含有子部门
            if(departmentInfoDao.countByFParentIdAndFCompanyId(one.getfId(),fCompanyId) != 0){
                //该部门含有子部门
                log.error("DepSetService - - delete :"+Status.DEPONEISTWO.getMessage());
                return result.setCodeId(Status.DEPONEISTWO);
            }
        }
        departmentInfoDao.delete(one);
        }catch (Exception e){
            e.printStackTrace();
            result.fail();
            log.error("DepSetService - - delete :",e);
            throw e;
        }
        return result;
    }
}
