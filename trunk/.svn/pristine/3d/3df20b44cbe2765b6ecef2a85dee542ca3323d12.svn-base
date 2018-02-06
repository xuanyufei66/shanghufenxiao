package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqComInfoBean;
import com.payease.scfordermis.entity.TCompanyInfoEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2018/1/16.
 * 公司信息
 */
@Service
public interface CompanyInfoService {
    //获取公司信息详情类
    ResultBo getComInfo(HttpSession session,Long fCompanyId)throws Exception;
    //更新公司信息类
    ResultBo saveComInfo(HttpSession session,ReqComInfoBean req)throws Exception;
    //根据公司id获取公司信息
    TCompanyInfoEntity findCompanyById(long fid);
}
