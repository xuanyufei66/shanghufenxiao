package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqLoginPCBean;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * Created by zhoushijie on 2018/1/16.
 */
@Service
public interface LoginPCService {
    //登录
    ResultBo login(HttpSession session,ReqLoginPCBean reqLoginPCBean) throws Exception;
    //登出
    ResultBo logout(HttpSession session) throws Exception;
}
