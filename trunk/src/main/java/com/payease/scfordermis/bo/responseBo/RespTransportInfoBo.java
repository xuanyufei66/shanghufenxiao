package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by YHF on 2018/1/12.
 */
@ApiModel(value = "运单详情返回运输信息实体类",description = "运单详情返回运输信息实体类")
public class RespTransportInfoBo {
    @ApiModelProperty(value = "运单id")
    private String transportId;
    @ApiModelProperty(value = "运输车辆")
    private String carNum;
    @ApiModelProperty(value = "司机")
    private String driverName;
    @ApiModelProperty(value = "手机号")
    private String driverPhone;

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
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
