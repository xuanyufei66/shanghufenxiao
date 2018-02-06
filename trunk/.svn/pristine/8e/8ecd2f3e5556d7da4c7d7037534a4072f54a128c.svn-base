package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zhoushijie on 2018/1/11.
 * 客户订单登录   入参
 */
@ApiModel(value = "登录客户端实体类",description = "登录客户端")
public class ReqLoginClientBean implements Serializable {

    @ApiModelProperty(value = "订货账号",dataType = "string",required = true)
    private String fIndentNo;
    @ApiModelProperty(value = "短信验证码",dataType = "string",required = true)
    private String fMsgCode;

    public String getfIndentNo() {
        return fIndentNo;
    }

    public void setfIndentNo(String fIndentNo) {
        this.fIndentNo = fIndentNo;
    }

    public String getfMsgCode() {
        return fMsgCode;
    }

    public void setfMsgCode(String fMsgCode) {
        this.fMsgCode = fMsgCode;
    }
}
