package com.payease.scfordermis.bo.responseBo.app.customer;

import com.payease.scfordermis.bo.responseBo.app.driver.RespAppGoodBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@ApiModel(value = "订单详情介绍")
public class RespAppCustomerOrderDetailBean {



    @ApiModelProperty(value = "订单id", dataType = "long")
    private long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNum;
    @ApiModelProperty(value = "下单时间")
    private String createtime;
    @ApiModelProperty(value = "商品总数", dataType = "integer")
    private int productNum;
    @ApiModelProperty(value = "订单状态0-待订单审核;1-待提货;2-已完成;-1-已作废")
    private int status;
    @ApiModelProperty(value = "订单金额／特价金额")
    private String orderAmount;
    @ApiModelProperty(value = "付款状态／wait-待付款；part-部分付款；completed-清")
    private String payStatus;
    @ApiModelProperty(value = "是否特价／yes-是；no-否")
    private String special;
    @ApiModelProperty(value = "市场金额")
    private String amount;
    @ApiModelProperty(value = "已付金额")
    private String paidAmount;
    @ApiModelProperty(value = "车牌号")
    private String cardNum;
    @ApiModelProperty(value = "司机名字")
    private String driverName;
    @ApiModelProperty(value = "司机手机号")
    private String driverPhone;

    public List<RespAppGoodBean> getGoodBeanList() {
        return goodBeanList;
    }

    public void setGoodBeanList(List<RespAppGoodBean> goodBeanList) {
        this.goodBeanList = goodBeanList;
    }

    private List<RespAppGoodBean> goodBeanList;


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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
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

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

}
