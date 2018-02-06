package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lch on 2018/1/11.
 *
 * 收款记录返回对象
 */
@ApiModel(value = "收款记录", description = "收款记录")
public class RspPaymentRecordsBo {

    @ApiModelProperty(value = "支付流水号", dataType = "string")
    private String fPayNum;
    @ApiModelProperty(value = "时间(格式为：yyyy.MM.dd hh:mm:ss)", dataType = "string")
    private String fCreatetime;
    @ApiModelProperty(value = "付款金额", dataType = "string")
    private String fAmount;
    @ApiModelProperty(value = "支付方式（bankCard-银行卡支付）", dataType = "string")
    private String fPaymethod;
    @ApiModelProperty(value = "备注", dataType = "string")
    private String fRemark;
    @ApiModelProperty(value = "状态（success-支付成功）", dataType = "string")
    private String fPayStatus;

    public String getfPayNum() {
        return fPayNum;
    }

    public void setfPayNum(String fPayNum) {
        this.fPayNum = fPayNum;
    }

    public String getfCreatetime() {
        return fCreatetime;
    }

    public void setfCreatetime(String fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    public String getfAmount() {
        return fAmount;
    }

    public void setfAmount(String fAmount) {
        this.fAmount = fAmount;
    }

    public String getfPaymethod() {
        return fPaymethod;
    }

    public void setfPaymethod(String fPaymethod) {
        this.fPaymethod = fPaymethod;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark;
    }

    public String getfPayStatus() {
        return fPayStatus;
    }

    public void setfPayStatus(String fPayStatus) {
        this.fPayStatus = fPayStatus;
    }
}
