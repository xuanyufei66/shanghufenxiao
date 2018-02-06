package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqComInfoBean;
import com.payease.scfordermis.bo.responseBo.RespComInfoBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.dao.CompanyInfoDao;
import com.payease.scfordermis.entity.TCompanyInfoEntity;
import com.payease.scfordermis.service.CompanyInfoService;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.Objects;


/**
 * Created by zhoushijie on 2018/1/16.
 */
@Service
public class CompanyInfoServiceImpl implements CompanyInfoService{
    private static final Logger log = LoggerFactory.getLogger(CompanyInfoServiceImpl.class);
    @Autowired
    CompanyInfoDao companyInfoDao;

    /**
     * 获取公司信息详情
     * @param session
     * @return
     */
    @Override
    public ResultBo getComInfo(HttpSession session,Long fCompanyId)throws Exception {
        ResultBo result = ResultBo.build();
        try{
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfId() == null){
                return result.timeOut();
            }
            //  Long sessionId
            Long sessionId = sessionInfo.getfId();//Long.valueOf("1");
            //通过(员工)fId找到账号id
            TCompanyInfoEntity comInfo = companyInfoDao.findOne(sessionId);
            if (comInfo ==null){
                return result.setCodeId(Status.CHECKACCERROR);
            }
            RespComInfoBean resp = new RespComInfoBean();
            //公司信息
            resp.setfName(comInfo.getfName());
            //行业类别
            resp.setfCategory(comInfo.getfCategory());
            //logoUrl
            resp.setfLogo(comInfo.getfLogo());
            //联系人
            resp.setfContact(comInfo.getfContact());
            //手机号码
            resp.setfMobile(comInfo.getfMobile());
            //邮箱
            resp.setfEmail(comInfo.getfEmail());

            //公司地址
            resp.setfAddress(comInfo.getfAddress());
            //邮编
            resp.setfPostalCode(comInfo.getfPostalCode());

            //电话号码
            resp.setfPhone(comInfo.getfPhone());

            //传真
            resp.setfFax(comInfo.getfFax());

            //公司网址
            resp.setfWebsite(comInfo.getfWebsite());

            //服务热线
            resp.setfServiceNumber(comInfo.getfServiceNumber());

            result.setResultBody(resp);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("getCompanyInfoError"+Status.COMPANYINFOERRO.getMessage(),e);
            result.setCodeId(Status.COMPANYINFOERRO);
            throw e;
        }
    }

    /**
     *更新公司信息
     * @param session
     * @param req
     * @return
     */
    @Override
    public ResultBo saveComInfo(HttpSession session, ReqComInfoBean req)throws Exception {
        ResultBo result = ResultBo.build();
        try{
            if(req == null || req.getfCompanyId() == null ){return  result.queryError();}
            RespLoginPCBean sessionInfo = (RespLoginPCBean)session.getAttribute("userInfo");
            if(sessionInfo== null || sessionInfo.getfCompanyId() == null || sessionInfo.getfId() == null){
                return result.timeOut();
            }
            //  Long fCompanyId
            Long SessionFCompanyId = sessionInfo.getfCompanyId(); //Long.valueOf("1");
            //  Long sessionId
            Long sessionId = sessionInfo.getfId();//Long.valueOf("1");
            if(!Objects.equals(SessionFCompanyId, req.getfCompanyId())){return result.setCodeId(Status.COMINFOERR);}

            //查找公司id
            TCompanyInfoEntity comId = companyInfoDao.findOne(sessionId);
            if (comId == null){
                return result.setCodeId(Status.CHECKACCERROR);
            }

            //联系人
            comId.setfContact(req.getfContact());
            //手机号码
            comId.setfMobile(req.getfMobile());
            //邮箱
            if (StringUtils.isNotBlank(req.getfEmail())){
                comId.setfEmail(req.getfEmail());
            }else {
                comId.setfEmail("");
            }
            //公司地址
            comId.setfAddress(req.getfAddress());
            //邮编
            if (StringUtils.isNotBlank(req.getfPhone())){
                comId.setfPostalCode(req.getfPostalCode());
            }else {
                comId.setfPostalCode("");
            }
            //电话号码
            if (StringUtils.isNotBlank(req.getfPhone())){
                comId.setfPhone(req.getfPhone());
            }else {
                comId.setfPhone("");
            }
            //传真
            if (StringUtils.isNotBlank(req.getfFax())){
                comId.setfFax(req.getfFax());
            }else {
                comId.setfFax("");
            }
            //公司网址
            if (StringUtils.isNotBlank(req.getfWebsite())){
                comId.setfWebsite(req.getfWebsite());
            }else {
                comId.setfWebsite("");
            }
            //服务热线
            comId.setfServiceNumber(req.getfServiceNumber());
            companyInfoDao.save(comId);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("saveComInfoError"+Status.SAVECOMINFOERROR.getMessage(),e);
            result.setCodeId(Status.SAVECOMINFOERROR);
            throw e;
        }
    }
    //根据公司id获取公司实体
    public TCompanyInfoEntity findCompanyById(long fid){
        return  companyInfoDao.findOne(fid);
    }
}
