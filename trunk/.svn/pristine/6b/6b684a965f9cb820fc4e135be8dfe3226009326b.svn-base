package com.payease.scfordermis.bo.responseBo.app.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@ApiModel(value = "订单实体类")
public class RespAppCustomerOrderBean {


    @ApiModelProperty(value = "订单id", dataType = "long")
    private long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNum;
    @ApiModelProperty(value = "商品总数", dataType = "integer")
    private int productNum;
    @ApiModelProperty(value = "订单状态0-待订单审核;1-待提货;2-已完成;-1-已作废")
    private int status;
    @ApiModelProperty(value = "订单金额")
    private String orderAmount;
    @ApiModelProperty(value = "下单时间")
    private String createtime;
    @ApiModelProperty(value = "付款状态／wait-待付款；part-部分付款；completed-清")
    private String payStatus;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}
