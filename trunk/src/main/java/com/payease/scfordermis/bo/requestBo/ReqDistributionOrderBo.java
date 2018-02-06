package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lch on 2018/1/10.
 *
 * 集散地订单列表入参对象
 */
@ApiModel(value = "集散地订单入参",description = "集散地订单的条件查询")
public class ReqDistributionOrderBo extends PageBean{

    @ApiModelProperty(value = "订单号",dataType = "string")
    private String orderNum;
    @ApiModelProperty(value = "开始时间（格式为：yyyy-MM-dd hh:mm）",dataType = "string")
    private String beginTime;
    @ApiModelProperty(value = "结束时间（格式为：yyyy-MM-dd hh:mm）",dataType = "string")
    private String endTime;
    @ApiModelProperty(value = "客户名称",dataType = "string")
    private String consumerName;
    @ApiModelProperty(value = "客户级别id(全部传空)",dataType = "string")
    private Long customerLevelId;
    @ApiModelProperty(value = "运单信息",dataType = "string")
    private String transportInfo;
    @ApiModelProperty(value = "销售地区id(全部传空)",dataType = "string")
    private Long areaInfoId;
    @ApiModelProperty(value = "销售地区级别(1-一级；2-二级)",dataType = "string")
    private String level;
    @ApiModelProperty(value = "订单状态复选框-高级搜索(全部传空,1-待订单审核;2-待提货;3-已完成;-1-已作废)",dataType = "string")
    private Integer[] orderStatus;
    @ApiModelProperty(value = "付款状态(全部传空,wait-待付款,part-部分付款,completed-已付款)",dataType = "string")
    private String[] payStatus;
    @ApiModelProperty(value = "关键字搜索(不点击高级搜索，直接点击搜索)",dataType = "string")
    private String searchKey;
    @ApiModelProperty(value = "订单状态下拉框(全部传空,1-待处理订单,2-未完成订单,3-已完成订单,4-已作废订单)",dataType = "string")
    private Long orderState;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Long getCustomerLevelId() {
        return customerLevelId;
    }

    public void setCustomerLevelId(Long customerLevelId) {
        this.customerLevelId = customerLevelId;
    }

    public String getTransportInfo() {
        return transportInfo;
    }

    public void setTransportInfo(String transportInfo) {
        this.transportInfo = transportInfo;
    }

    public Long getAreaInfoId() {
        return areaInfoId;
    }

    public void setAreaInfoId(Long areaInfoId) {
        this.areaInfoId = areaInfoId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer[] getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer[] orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String[] getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String[] payStatus) {
        this.payStatus = payStatus;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Long getOrderState() {
        return orderState;
    }

    public void setOrderState(Long orderState) {
        this.orderState = orderState;
    }
}
