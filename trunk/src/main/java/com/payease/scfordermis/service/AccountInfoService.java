package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqAccInfoResetPwdBean;
import com.payease.scfordermis.bo.requestBo.ReqAccountInfoBean;


import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2018/1/17.
 * 账号信息
 */

public interface AccountInfoService {
    //重置密码
    ResultBo savepwd(HttpSession session,ReqAccInfoResetPwdBean reqAccInfoResetPwdBean)throws Exception;
    //修改用户信息
    ResultBo saveaccinfo(HttpSession session,ReqAccountInfoBean req)throws Exception;
}
