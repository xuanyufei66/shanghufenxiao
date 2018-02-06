package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqAccInfoResetPwdBean;
import com.payease.scfordermis.bo.requestBo.ReqAccountInfoBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.dao.EmployeeInfoDao;
import com.payease.scfordermis.entity.TEmployeeInfoEntity;
import com.payease.scfordermis.service.AccountInfoService;
import com.payease.scfordermis.utils.MD5;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * Created by zhoushijie on 2018/1/17.
 * 账号实现类
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService{
    private static final Logger log = LoggerFactory.getLogger(AccountInfoServiceImpl.class);
    @Autowired
    EmployeeInfoDao employeeInfoDao;
    /**
     * 重置密码
     */
    @Override
    public ResultBo savepwd(HttpSession session, ReqAccInfoResetPwdBean reqAccInfoResetPwdBean) throws Exception{
        ResultBo result = ResultBo.build();
        try{
            if(reqAccInfoResetPwdBean == null || reqAccInfoResetPwdBean.getfId() == null){return result.queryError();}
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo == null  || sessionInfo.getfId() == null ){
                return result.timeOut();
            }
            //登录账号
            if(!Objects.equals(sessionInfo.getfId(), reqAccInfoResetPwdBean.getfId())){
                return result.setCodeId(Status.ACCIDISNULL);
            }
            //  Long sessionId
            Long sessionId = sessionInfo.getfId();//Long.valueOf("1");

            //检查入参的账号Id与session中获取是否一致
           if (!reqAccInfoResetPwdBean.getfId().equals(sessionId)){
               return result.setCodeId(Status.CHECKACCIDERR);
           }
            //通过fid找到账号id
            TEmployeeInfoEntity accId = employeeInfoDao.findOne(sessionId);
            if (accId == null){return result.setCodeId(Status.ACCIDISNULL);}
            //检查原密码是否为空
            if (StringUtils.isBlank(reqAccInfoResetPwdBean.getOldPwd())){return result.setCodeId(Status.CHECKOLDPWDISNULL);}
            //检查新密码是否为空
            if (StringUtils.isBlank(reqAccInfoResetPwdBean.getNewPwd())){return result.setCodeId(Status.CHECKNEWPWDISNULL);}

            //  判断入参原密码加密后和数据库中密码是否一致
            if (MD5.encode(reqAccInfoResetPwdBean.getOldPwd()).equals(accId.getfPassword())){
                //修改时间
                accId.setfUpdateTime(new Date());
                //将数据库中的登录密码修改为新密码
                accId.setfPassword(MD5.encode(reqAccInfoResetPwdBean.getNewPwd()));
                employeeInfoDao.save(accId);
            }else {
                result.setCodeId(Status.SETCHECKERROR);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("AccountSavepwdError",e);
            result.setCodeId(Status.SAVEPWDERROR);
            throw e;
        }
    }

    /**
     *修改用户信息
     */
    @Override
    public ResultBo saveaccinfo(HttpSession session,ReqAccountInfoBean req) throws Exception{
        //通过id找到一个对象
        ResultBo result = ResultBo.build();
        try{
            if(req == null || req.getfId() == null || StringUtils.isBlank(req.getfMobile())){return result.queryError();}
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfId() == null ){
                return result.timeOut();
            }
            //判断员工id是否一致
            if (!Objects.equals(sessionInfo.getfId(), req.getfId())){
                return result.setCodeId(Status.ACCIDISNULL);
            }
            //  Long sessionId
            Long sessionId = sessionInfo.getfId();

            //通过fId找到账号id
            TEmployeeInfoEntity entity = employeeInfoDao.findOne(sessionId);
            if(entity == null){return result.setCodeId(Status.ACCINFOFAIL);}
            //判断手机号是否唯一
            if(!entity.getfMobile().equals(req.getfMobile()) && employeeInfoDao.countByFMobile(req.getfMobile()) != 0){
                return result.setCodeId(Status.MOBILEEXIST);
            }

            //名字
            entity.setfName(req.getfName());
            //手机
            entity.setfMobile(req.getfMobile());
            //邮箱
            if (StringUtils.isNotBlank(req.getfEmail())){
                entity.setfEmail(req.getfEmail());
            }else {
                entity.setfEmail("");
            }
            employeeInfoDao.save(entity);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("AccountSaveAccInfoError",e);
            result.setCodeId(Status.SAVEACCINFOERROR);
            throw e;
        }
    }
}
