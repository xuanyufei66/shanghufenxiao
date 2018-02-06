package com.payease.scfordermis.bo.responseBo.app.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午5:38
 **/
@ApiModel(value = "消息",description = "描述消息")
public class RespMsgBean {

    @ApiModelProperty(value = "主键ID",dataType = "long")
    private Long fId;
    @ApiModelProperty(value = "订单ID: 外链id 若为订单消息类型，则对应订单表主键id",dataType = "long")
    private Long orderId;
    @ApiModelProperty(value = "消息标题",dataType = "string")
    private String fMsgTitle;
    @ApiModelProperty(value = "消息简介",dataType = "string")
    private String fMsgDesc;
    @ApiModelProperty(value = "消息时间",dataType = "date")
    private Date msgTime;
    @ApiModelProperty(value = "消息类型 order:订单消息",dataType = "string")
    private String fMsgType;
    @ApiModelProperty(value = "消息状态 read：已读 unread:未读",dataType = "string")
    private String fMsgStatus;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getfMsgTitle() {
        return fMsgTitle;
    }

    public void setfMsgTitle(String fMsgTitle) {
        this.fMsgTitle = fMsgTitle;
    }

    public String getfMsgDesc() {
        return fMsgDesc;
    }

    public void setfMsgDesc(String fMsgDesc) {
        this.fMsgDesc = fMsgDesc;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public String getfMsgType() {
        return fMsgType;
    }

    public void setfMsgType(String fMsgType) {
        this.fMsgType = fMsgType;
    }

    public String getfMsgStatus() {
        return fMsgStatus;
    }

    public void setfMsgStatus(String fMsgStatus) {
        this.fMsgStatus = fMsgStatus;
    }
}
