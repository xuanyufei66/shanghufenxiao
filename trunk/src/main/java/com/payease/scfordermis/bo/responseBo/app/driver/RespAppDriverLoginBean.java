package com.payease.scfordermis.bo.responseBo.app.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhoushijie on 2018/1/23.
 * 司机端 出参
 */
@ApiModel(value = "司机端登录",description = "司机端登录出参实体类")
public class RespAppDriverLoginBean {
    @ApiModelProperty(value = "token",dataType = "string",required = true)
    private String token;
    @ApiModelProperty(value = "运单id",dataType = "long")
    private Long  id;
    @ApiModelProperty(value = "公司id",dataType = "long")
    private Long fCompanyId;
    @ApiModelProperty(value = "车牌号码",dataType = "string")
    private String fCarNum;
    @ApiModelProperty(value = "运输单号",dataType = "string")
    private String fTransportNum;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(Long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    public String getfCarNum() {
        return fCarNum;
    }

    public void setfCarNum(String fCarNum) {
        this.fCarNum = fCarNum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getfTransportNum() {
        return fTransportNum;
    }

    public void setfTransportNum(String fTransportNum) {
        this.fTransportNum = fTransportNum;
    }
}
