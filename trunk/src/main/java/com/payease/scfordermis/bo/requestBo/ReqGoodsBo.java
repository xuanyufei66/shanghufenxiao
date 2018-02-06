package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by YHF on 2018/1/11.
 */
@ApiModel(value = "运单添加商品参数类",description = "运单添加商品参数类")
public class ReqGoodsBo {
    @ApiModelProperty(value = "商品id")
    private String fProductId;
    @ApiModelProperty(value = "商品单位id")
    private String fUnitId;
    @ApiModelProperty(value = "规格id")
    private String fProductFormatId;
    @ApiModelProperty(value = "计划装车数")
   private String planNum;
    @ApiModelProperty(value = "运单详情id")
    private String transportDetailId;

    public String getfUnitId() {
        return fUnitId;
    }

    public void setfUnitId(String fUnitId) {
        this.fUnitId = fUnitId;
    }

    public String getTransportDetailId() {
        return transportDetailId;
    }

    public void setTransportDetailId(String transportDetailId) {
        this.transportDetailId = transportDetailId;
    }

    public String getfProductId() {
        return fProductId;
    }

    public void setfProductId(String fProductId) {
        this.fProductId = fProductId;
    }

    public String getfProductFormatId() {
        return fProductFormatId;
    }

    public void setfProductFormatId(String fProductFormatId) {
        this.fProductFormatId = fProductFormatId;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }
}
