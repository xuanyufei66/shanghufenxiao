package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.responseBo.RespIndexListBean;

import javax.servlet.http.HttpSession;

/**
 * @Author : zhangwen
 * @Data : 2018/1/16
 * @Description :
 */
public interface IIndexService {

    /**
     * @Author zhangwen
     * @MethodName index
     * @Params String queryType
     * @Return RespIndexListBean
     * @Date 2018/1/16 上午10:43
     * @Desp 首页获取信息接口
     */
    public RespIndexListBean index(HttpSession session, String queryType) throws Exception;

}
