package com.payease.scfordermis.bo.responseBo.app.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@ApiModel(value = "支付详情")
public class RespAppPayDetailBean {


    @ApiModelProperty(value = "订单id", dataType = "long")
    private long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNum;
    @ApiModelProperty(value = "客户名字")
    private String customer;
    @ApiModelProperty(value = "订单金额／特价金额")
    private String orderAmount;
    @ApiModelProperty(value = "已付金额")
    private String paidAmount;
    @ApiModelProperty(value = "付款状态／wait-待付款；part-部分付款；completed-清")
    private String payStatus;

    private List<RespAppPayHistoryBean> historyBeanList;



    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public List<RespAppPayHistoryBean> getHistoryBeanList() {
        return historyBeanList;
    }

    public void setHistoryBeanList(List<RespAppPayHistoryBean> historyBeanList) {
        this.historyBeanList = historyBeanList;
    }
}
