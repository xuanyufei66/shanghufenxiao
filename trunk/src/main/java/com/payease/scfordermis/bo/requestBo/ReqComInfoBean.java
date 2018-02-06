package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by zhoushijie on 2018/1/10.
 * 入参
 */
@ApiModel(value = "获取公司信息详情类",description = "获取公司信息详情类")
public class ReqComInfoBean {

    @ApiModelProperty(value = "公司id",dataType = "Long",required = true)
    private Long fCompanyId;
    @ApiModelProperty(value = "联系人",dataType = "string",required = true)
    private String fContact;
    @ApiModelProperty(value = "手机号码",dataType = "string",required = true)
    private String fMobile;
    @ApiModelProperty(value = "邮箱",dataType = "string")
    private String fEmail;
    @ApiModelProperty(value = "公司地址",dataType = "string",required = true)
    private String fAddress;
    @ApiModelProperty(value = "邮编",dataType = "string")
    private String fPostalCode;
    @ApiModelProperty(value = "电话号码",dataType = "string")
    private String fPhone;
    @ApiModelProperty(value = "传真",dataType = "string")
    private String fFax;
    @ApiModelProperty(value = "公司网址",dataType = "string")
    private String fWebsite;
    @ApiModelProperty(value = "服务热线",dataType = "string",required = true)
    private String fServiceNumber;
//    @ApiModelProperty(value = "主键id(公司)",dataType = "long")
//    private Long fId;
//    @ApiModelProperty(value = "创建时间",dataType = "date")
//    private Date fCreateTime;


    public Long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(Long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    public String getfContact() {
        return fContact;
    }

    public void setfContact(String fContact) {
        this.fContact = fContact;
    }

    public String getfMobile() {
        return fMobile;
    }

    public void setfMobile(String fMobile) {
        this.fMobile = fMobile;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress;
    }

    public String getfPostalCode() {
        return fPostalCode;
    }

    public void setfPostalCode(String fPostalCode) {
        this.fPostalCode = fPostalCode;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getfFax() {
        return fFax;
    }

    public void setfFax(String fFax) {
        this.fFax = fFax;
    }

    public String getfWebsite() {
        return fWebsite;
    }

    public void setfWebsite(String fWebsite) {
        this.fWebsite = fWebsite;
    }

    public String getfServiceNumber() {
        return fServiceNumber;
    }

    public void setfServiceNumber(String fServiceNumber) {
        this.fServiceNumber = fServiceNumber;
    }


}
