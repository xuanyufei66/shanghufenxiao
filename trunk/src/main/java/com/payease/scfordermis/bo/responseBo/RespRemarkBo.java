package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lch on 2018/1/12.
 *
 * 备注说明（订单详情中的备注说明列表对象）
 */
@ApiModel(value = "备注说明",description = "备注说明")
public class RespRemarkBo {

    @ApiModelProperty(value = "备注内容", dataType = "string")
    private String fContent;
    @ApiModelProperty(value = "备注操作人", dataType = "string")
    private String operator;
    @ApiModelProperty(value = "备注时间(格式为：yyyy-MM-dd hh:mm)", dataType = "string")
    private String fCreatetime;

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getfCreatetime() {
        return fCreatetime;
    }

    public void setfCreatetime(String fCreatetime) {
        this.fCreatetime = fCreatetime;
    }
}
