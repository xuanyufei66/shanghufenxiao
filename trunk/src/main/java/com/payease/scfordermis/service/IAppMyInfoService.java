package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.responseBo.RespClientInfo;

/**
 * @Author : zhangwen
 * @Data : 2018/1/22
 * @Description :
 */
public interface IAppMyInfoService {

    /**
     * @Author zhangwen
     * @MethodName getConsumerDetail
     * @Params String token
     * @Return RespClientInfo
     * @Date 2018/1/22 下午2:49
     * @Desp 获取客户详细信息 app端-我的 使用
     */
    public RespClientInfo getConsumerDetail(String token) throws Exception;
}
