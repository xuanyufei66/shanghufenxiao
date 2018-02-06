package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by lch on 2018/1/11.
 * <p>
 * 订单详情返回对象
 */
@ApiModel(value = "订单详情", description = "订单详情")
public class RespOrderDetailsBo {

    //以下为订单详情中的订单内容
    @ApiModelProperty(value = "订单id", dataType = "long")
    private Long id;
    @ApiModelProperty(value = "订单号", dataType = "string")
    private String fOrderNum;
    @ApiModelProperty(value = "是否是特价(yes-是特价,no-不是特价)", dataType = "string")
    private String fSpecial;
    @ApiModelProperty(value = "客户名称", dataType = "string")
    private String consumerName;
    @ApiModelProperty(value = "制单员", dataType = "string")
    private String fOrderCreater;
    @ApiModelProperty(value = "下单时间(格式为：yyyy-MM-dd hh:mm)", dataType = "string")
    private String fCreateTime;
    @ApiModelProperty(value = "订单金额", dataType = "string")
    private String fOrderAmountPay;
    @ApiModelProperty(value = "已付款金额", dataType = "string")
    private String fPaidMoney;
    @ApiModelProperty(value = "交易方式(prePayAll-预付所有;prePayPary-预付部分;notPrePay-赊销)", dataType = "string")
    private String fPayMethod;
    @ApiModelProperty(value = "预付金额(交易方式为prePayPary时有值)", dataType = "string")
    private String fPreAmount;
    @ApiModelProperty(value = "订单状态(0-待订单审核;1-待提货;2-已完成;-1-已作废)", dataType = "string")
    private int fOrderStatus;
    @ApiModelProperty(value = "商品总金额（合计中的）", dataType = "string")
    private String fAmount;
    @ApiModelProperty(value = "商品总数量（合计中的）", dataType = "string")
    private int fProductNum;
    //以下为订单详情中的商品内容
    @ApiModelProperty(value = "订单中商品信息", dataType = "list")
    private List<RespProductBo> productBoList;
    //以下为订单详情中的运单信息
    @ApiModelProperty(value = "销售地区", dataType = "string")
    private String areaInfoName;
    @ApiModelProperty(value = "车牌号码", dataType = "string")
    private String fCarNum;
    @ApiModelProperty(value = "司机", dataType = "string")
    private String fDriverName;
    @ApiModelProperty(value = "登录账号", dataType = "string")
    private String fDriverPhone;
    //以下为订单详情中的备注说明
    @ApiModelProperty(value = "备注说明", dataType = "list")
    private List<RespRemarkBo> remarkBoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfOrderNum() {
        return fOrderNum;
    }

    public void setfOrderNum(String fOrderNum) {
        this.fOrderNum = fOrderNum;
    }

    public String getfSpecial() {
        return fSpecial;
    }

    public void setfSpecial(String fSpecial) {
        this.fSpecial = fSpecial;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getfOrderCreater() {
        return fOrderCreater;
    }

    public void setfOrderCreater(String fOrderCreater) {
        this.fOrderCreater = fOrderCreater;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getfOrderAmountPay() {
        return fOrderAmountPay;
    }

    public void setfOrderAmountPay(String fOrderAmountPay) {
        this.fOrderAmountPay = fOrderAmountPay;
    }

    public String getfPaidMoney() {
        return fPaidMoney;
    }

    public void setfPaidMoney(String fPaidMoney) {
        this.fPaidMoney = fPaidMoney;
    }

    public String getfPayMethod() {
        return fPayMethod;
    }

    public void setfPayMethod(String fPayMethod) {
        this.fPayMethod = fPayMethod;
    }

    public String getfPreAmount() {
        return fPreAmount;
    }

    public void setfPreAmount(String fPreAmount) {
        this.fPreAmount = fPreAmount;
    }

    public int getfOrderStatus() {
        return fOrderStatus;
    }

    public void setfOrderStatus(int fOrderStatus) {
        this.fOrderStatus = fOrderStatus;
    }

    public String getfAmount() {
        return fAmount;
    }

    public void setfAmount(String fAmount) {
        this.fAmount = fAmount;
    }

    public int getfProductNum() {
        return fProductNum;
    }

    public void setfProductNum(int fProductNum) {
        this.fProductNum = fProductNum;
    }

    public List<RespProductBo> getProductBoList() {
        return productBoList;
    }

    public void setProductBoList(List<RespProductBo> productBoList) {
        this.productBoList = productBoList;
    }

    public String getAreaInfoName() {
        return areaInfoName;
    }

    public void setAreaInfoName(String areaInfoName) {
        this.areaInfoName = areaInfoName;
    }

    public String getfCarNum() {
        return fCarNum;
    }

    public void setfCarNum(String fCarNum) {
        this.fCarNum = fCarNum;
    }

    public String getfDriverName() {
        return fDriverName;
    }

    public void setfDriverName(String fDriverName) {
        this.fDriverName = fDriverName;
    }

    public String getfDriverPhone() {
        return fDriverPhone;
    }

    public void setfDriverPhone(String fDriverPhone) {
        this.fDriverPhone = fDriverPhone;
    }

    public List<RespRemarkBo> getRemarkBoList() {
        return remarkBoList;
    }

    public void setRemarkBoList(List<RespRemarkBo> remarkBoList) {
        this.remarkBoList = remarkBoList;
    }
}
