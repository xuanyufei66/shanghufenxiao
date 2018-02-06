package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@ApiModel(value = "首页展示数据返回类",description = "描述首页数据")
public class RespIndexListBean {

    @ApiModelProperty(value = "订货单数量",dataType = "int")
    private int orderTotalNumber;
    @ApiModelProperty(value = "订货单客户数",dataType = "int")
    private int orderConsumerNumber;
    @ApiModelProperty(value = "订单金额",dataType = "string")
    private String orderMoney;
    @ApiModelProperty(value = "线性数据",dataType = "list")
    private List<String[]> linear;


    public int getOrderTotalNumber() {
        return orderTotalNumber;
    }

    public void setOrderTotalNumber(int orderTotalNumber) {
        this.orderTotalNumber = orderTotalNumber;
    }

    public int getOrderConsumerNumber() {
        return orderConsumerNumber;
    }

    public void setOrderConsumerNumber(int orderConsumerNumber) {
        this.orderConsumerNumber = orderConsumerNumber;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public List<String[]> getLinear() {
        return linear;
    }

    public void setLinear(List<String[]> linear) {
        this.linear = linear;
    }
}
