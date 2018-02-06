package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqCustomerBean;
import com.payease.scfordermis.bo.requestBo.ReqMyCustomerTwoBo;
import com.payease.scfordermis.bo.responseBo.RespCustomerBean;
import com.payease.scfordermis.bo.responseBo.RespEmpCustomerBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.dao.AreaInfoDao;
import com.payease.scfordermis.dao.ConsumerLevelDao;
import com.payease.scfordermis.dao.CustomerDao;
import com.payease.scfordermis.entity.TAreaInfoEntity;
import com.payease.scfordermis.entity.TConsumerInfoEntity;
import com.payease.scfordermis.entity.TConsumerLevelEntity;
import com.payease.scfordermis.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/1/10.
 */
@Service
public class CustomerServiceImpl  implements CustomerService{

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    EntityManager em;

    @Autowired
    private  CustomerDao cusromerDao;

    @Autowired
    private  AreaInfoDao   areaInfoDao;

    @Autowired
    private ConsumerLevelDao consumerLevelDao;

    /**
     * 客户管理获取首页信息
     * @param
     * @return
     */
    @Override
    public ResultBo selectIndext(ReqCustomerBean reqCustomerBean,HttpSession session)throws Exception {
            ResultBo result = ResultBo.build();
        try {
            int stays = reqCustomerBean.getAreaParentId();
            int start =(reqCustomerBean.getPage() -1)*reqCustomerBean.getSize();
            StringBuffer sql = new StringBuffer("SELECT *  FROM  t_consumer_info ");
            sql.append(this.FightString(stays,reqCustomerBean,session));
            sql.append("limit "+start+","+reqCustomerBean.getSize());
            StringBuffer sqlCount = new StringBuffer("SELECT count(*)  FROM  t_consumer_info ");
            sqlCount.append(this.FightString(stays,reqCustomerBean,session));
            Object o =  em.createNativeQuery(sqlCount.toString()).getSingleResult();
            int totalCount = Integer.valueOf(o.toString()).intValue();//总条数
            int t1 = totalCount/reqCustomerBean.getSize();//总页数
            if( totalCount%reqCustomerBean.getSize()>0){t1 = t1+1;}
            RespCustomerBean respCustomerBean = new RespCustomerBean();
            List<TConsumerInfoEntity> TconList = em.createNativeQuery(sql.toString(),TConsumerInfoEntity.class).getResultList();
            if (TconList!=null && !TconList.isEmpty()){
            List<RespEmpCustomerBean> respCuList = new ArrayList<>();
            for (TConsumerInfoEntity Tci:TconList) {
                RespEmpCustomerBean resp = new RespEmpCustomerBean();
                resp.setfId(Tci.getfId());//id
                resp.setfCode(Tci.getfCode());//客户编码
                resp.setfName(Tci.getfName());//客户名称
                resp.setCodeName(Tci.getfIndentNo());//登陆账号
                TAreaInfoEntity tar =areaInfoDao.findOne(Tci.getfAreaIdTwo());
                //TAreaInfoEntity tar1 = new TAreaInfoEntity();
                //tar1.setfName("");
                //if (stays!=0) {
                //     tar1 = areaInfoDao.findOne(Long.valueOf(stays));
                //}
                TConsumerLevelEntity tcl = consumerLevelDao.findOne(Tci.getfLevelId());
                resp.setfLevelId(tcl.getfName());//级别名称
                resp.setfAreaIdOneAndTwo(tar.getfName());//销售地区名称
                resp.setfContact(Tci.getfContact());//联系人
                resp.setfIndentStatus(Tci.getfIndentStatus());//控制状态
                respCuList.add(resp);
            }
            List<Object> mycuList = new ArrayList<>(respCuList);
            respCustomerBean.setList(mycuList);
            respCustomerBean.setNumber(reqCustomerBean.getPage());
            respCustomerBean.setSize(reqCustomerBean.getSize());
            respCustomerBean.setTotalElements(totalCount);
            respCustomerBean.setTotalPages(t1);
             result.setResultBody(respCustomerBean);
            }else {
            result.setCodeId(Status.NOQUALIFIEDVALUE);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.error("CustomerServiceImpl--selectIndext",e);
            throw e;
        }
           return  result;
    }

      public  StringBuffer  FightString(int stays,ReqCustomerBean reqCustomerBean,HttpSession session){
          try {
              StringBuffer myCount  = new StringBuffer("");
              RespLoginPCBean resp = (RespLoginPCBean)session.getAttribute("userInfo");
              //地区id为-1时表示查询全部
              myCount.append("where  f_company_id  =" + resp.getfCompanyId()+"  ");
              myCount.append("and  f_is_delete = 'no'  " );
              if (reqCustomerBean.getAreaId()!=-1){
              //表示入参没有父id，入参地区选择的是大地区
              if (stays==0){
                  myCount.append("and  f_area_id_one = "+ reqCustomerBean.getAreaId()+"  ");
              }else {
                  myCount.append("and  f_area_id_two = "+reqCustomerBean.getAreaId()+"  ");
              }
              }
              //客户级别为-1时表示查询全部客户级别
              if(reqCustomerBean.getLevel()!=-1){
                  if (reqCustomerBean.getLevel()!=0){
                      myCount.append("and  f_level_id ="+ reqCustomerBean.getLevel()+"   ");
                  }
              }
              if (StringUtils.isNotBlank(reqCustomerBean.getQueryConditions())){
                  myCount.append("and  f_search_key  like '%"+reqCustomerBean.getQueryConditions()+"%'  ");
              }
              return myCount;
          } catch (Exception e) {
              e.printStackTrace();
              log.error("CustomerServiceImpl--FightString",e);
              throw e;
          }
      }

    /**
     * 删除客户（假删除）
     * @param
     * @return
     */
    @Override
    public void  isDelete(HttpSession session , long fid) throws Exception{
        try {
            String fIsDelete ="yes";
            TConsumerInfoEntity tConsumerInfoEntity = cusromerDao.findOne(fid);
            RespLoginPCBean resp = (RespLoginPCBean)session.getAttribute("userInfo");
            tConsumerInfoEntity.setfIsDelete(fIsDelete);
            tConsumerInfoEntity.setfUpdateTime(new Date());
            tConsumerInfoEntity.setfOperate(resp.getfId());
            cusromerDao.save(tConsumerInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("CustomerServiceImpl--isDelete",e);
            throw e;
        }
    }
    /**
     * 获取客户详情
     * @param
     * @return
     */
    @Override
    public ResultBo  getDetail(long fid) throws Exception{
        ResultBo result = ResultBo.build();
        try {
            TConsumerInfoEntity  consumerFo =cusromerDao.findOne(fid);
             result.setResultBody(consumerFo);
        } catch (Exception e) {
            e.printStackTrace();
            result.fail();
            log.error("CustomerServiceImpl--getDetail",e);
            throw e;
        }
           return  result;
    }
    /**
     * 添加和修改
     * @param
     * @return
     */
    @Override
    public ResultBo upAndSave(HttpSession session, ReqMyCustomerTwoBo reqMyCustomerTwoBo) throws Exception {
        ResultBo result = ResultBo.build();
        try {
        RespLoginPCBean resp = (RespLoginPCBean)session.getAttribute("userInfo");
        TConsumerInfoEntity tConsumerInfoEntity = new TConsumerInfoEntity();
        BeanUtils.copyProperties(reqMyCustomerTwoBo,tConsumerInfoEntity);
        tConsumerInfoEntity.setfId(reqMyCustomerTwoBo.getId());
            //添加搜索条件
         if (StringUtils.isNotBlank(tConsumerInfoEntity.getfCode())){
             tConsumerInfoEntity.setfCode("");
         }
         String conKey =    tConsumerInfoEntity.getfName()
                 + tConsumerInfoEntity.getfCode()
                 + tConsumerInfoEntity.getfContact()
                 + tConsumerInfoEntity.getfPhone();
                 tConsumerInfoEntity.setfSearchKey(conKey);
            tConsumerInfoEntity.setfOperate(resp.getfId());
            tConsumerInfoEntity.setfCompanyId(resp.getfCompanyId());
            //修改操作
            List<TConsumerInfoEntity> leve =cusromerDao.findByFNameAndFCompanyId(tConsumerInfoEntity.getfName(),resp.getfCompanyId());
            if (0 != tConsumerInfoEntity.getfId()) {
                if (leve.size() == 1) {
                long myid =   leve.get(0).getfId();
                if (myid==reqMyCustomerTwoBo.getId()) {//名字和id相等代表是一条数据
                    TConsumerInfoEntity tConsumerInfoEntity1 = cusromerDao.findOne(reqMyCustomerTwoBo.getId());
                    tConsumerInfoEntity1.setfSearchKey(conKey);
                    tConsumerInfoEntity1.setfOperate(resp.getfId());
                    tConsumerInfoEntity1.setfCompanyId(resp.getfCompanyId());
                    BeanUtils.copyProperties(reqMyCustomerTwoBo, tConsumerInfoEntity1);
                    tConsumerInfoEntity1.setfUpdateTime(new Date());
                    cusromerDao.saveAndFlush(tConsumerInfoEntity1);
                }else {
                    return result.setCodeId(Status.CUSTOMERNAMEALREADYEXISTS);
                }
                } else {
                    return result.setCodeId(Status.CUSTOMERNAMEALREADYEXISTS);
                }
            } else { //新增操作
                if (leve.size() == 0) {
                    tConsumerInfoEntity.setfIsDelete("no");
                    tConsumerInfoEntity.setfCreateTime(new Date());
                    tConsumerInfoEntity.setfIndentStatus("open");
                    tConsumerInfoEntity.setfIndentNo(tConsumerInfoEntity.getfPhone());
                    cusromerDao.save(tConsumerInfoEntity);
                } else {
                    return result.setCodeId(Status.CUSTOMERNAMEALREADYEXISTS);
                }
            }
                return result.setCodeId(Status.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("CustomerServiceImpl--upAndSave", e);
            throw e;
        }
    }

    //public  void  setmy(HttpSession session){
    //    RespLoginPCBean respLoginPCBean = new RespLoginPCBean();
    //    respLoginPCBean.setfName("京a12343");
    //    respLoginPCBean.setfAccount("香港");
    //    respLoginPCBean.setfId(Long.valueOf(1));
    //    respLoginPCBean.setfCompanyId(Long.valueOf(1));
    //    session.setAttribute("userInfo",respLoginPCBean);
    //}
}

