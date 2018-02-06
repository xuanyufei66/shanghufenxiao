package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqMsgListBean;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/17 下午2:21
 **/
public interface AppCustomerMsgService {

    ResultBo unReadMsg(String token) throws Exception;

    ResultBo updMsgStatus(String token, Long msgId) throws Exception;

    ResultBo msgList(String token,ReqMsgListBean req) throws Exception;
}
