package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqLoginClientBean;
import com.payease.scfordermis.entity.TConsumerInfoEntity;


/**
 * Created by zhoushijie on 2018/1/17.
 * App端登录Service
 */
public interface LoginClientService {
    //登录
    ResultBo login(ReqLoginClientBean req)throws Exception;

    //自动登录
    ResultBo autoLogin(String token)throws Exception;
   //根据token获取redis中的用户信息
   TConsumerInfoEntity getUserInRedis(String token) throws Exception;
    //登出
    ResultBo logout(String token)throws Exception;

}
