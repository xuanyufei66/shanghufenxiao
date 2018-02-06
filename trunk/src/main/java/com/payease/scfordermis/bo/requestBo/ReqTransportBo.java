package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by YHF on 2018/1/11.
 */
@ApiModel(value = "运输单请求参数实体类",description = "运输单请求参数实体类")
public class ReqTransportBo extends  PageBean{
    @ApiModelProperty(value = "运输单状态（ ForLoading-待装车；ForGoods-待提货；HasCompleted-已完成 ,例：全部状态为{\"transportStatus\": [\"ForLoading\", \"ForGoods\", \"HasCompleted\"]},后台以string类型数组接收，" +
            "运单状态为待装车、待提货时，用户可以在【集散地订单】页面针对该笔运单进行下单操作。）",dataType = "string",required = true)
    private  String[] transportStatus; //运输单状态
    @ApiModelProperty(value = "运单信息（运单号/车牌号/司机/手机号）",dataType = "string")
    private String  transInfo;  //运单号/车牌号/司机/手机号
    @ApiModelProperty(value = "下单时间（从）时间格式 ： yyyy-MM-dd HH:mm:ss")
    private String timeFrom;
    @ApiModelProperty(value = "下单时间（至）时间格式 ： yyyy-MM-dd HH:mm:ss")
    private String timeTo;
    @ApiModelProperty(value = "销售地区(一级)id",dataType = "string",required = true)
    private String sendAreaOne;
    @ApiModelProperty(value = "销售地区(二级)id",dataType = "string",required = true)
    private String sendAreaTwo;

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String[] getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(String[] transportStatus) {
        this.transportStatus = transportStatus;
    }

    public String getTransInfo() {
        return transInfo;
    }

    public void setTransInfo(String transInfo) {
        this.transInfo = transInfo;
    }


    public String getTimeTo() {
        return timeTo;
    }

    public String getSendAreaOne() {
        return sendAreaOne;
    }

    public void setSendAreaOne(String sendAreaOne) {
        this.sendAreaOne = sendAreaOne;
    }

    public String getSendAreaTwo() {
        return sendAreaTwo;
    }

    public void setSendAreaTwo(String sendAreaTwo) {
        this.sendAreaTwo = sendAreaTwo;
    }
}
