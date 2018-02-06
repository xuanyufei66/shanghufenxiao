package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.requestBo.ReqOrderMoneyBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.bo.responseBo.RespOrderMoneyListBean;
import com.payease.scfordermis.bo.responseBo.RespOrderMoneyTotalBean;

import javax.servlet.http.HttpSession;

/**
 * @Author : zhangwen
 * @Data : 2018/1/17
 * @Description :
 */
public interface IOrderMoneyService {

    /**
     * @Author zhangwen
     * @MethodName getMoney
     * @Params HttpSession session, ReqOrderMoneyBean orderMoneyBean
     * @Return RespOrderMoneyTotalBean
     * @Date 2018/1/17 上午10:55
     * @Desp 获取金额总数接口
     */
    public RespOrderMoneyTotalBean getMoney(HttpSession session, ReqOrderMoneyBean orderMoneyBean) throws Exception;

    /**
     * @Author zhangwen
     * @MethodName getList
     * @Params HttpSession session, ReqOrderMoneyBean orderMoneyBean
     * @Return PageResponseCommBean
     * @Date 2018/1/17 上午10:56
     * @Desp 获取订单收款统计列表
     */
    public PageResponseCommBean getList(HttpSession session, ReqOrderMoneyBean orderMoneyBean) throws Exception;
}
