package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * Created by zhoushijie on 2018/1/11.
 * 出参
 */
@ApiModel(value = "后台登录实体类",description = "后台登录实体类类")
public class RespLoginPCBean implements Serializable{
    @ApiModelProperty(value = "姓名",dataType = "string",required = true)
    private String fName;
    @ApiModelProperty(value = "员工id",dataType = "long",required = true)
    private Long fId;
    @ApiModelProperty(value = "菜单权限列表",dataType = "array",required = true)
    private String fMenus;
    @ApiModelProperty(value = "登录账号",dataType = "string")
    private String fAccount;
    @ApiModelProperty(value = "部门名称",dataType = "string")
    private String fDepartName;
    @ApiModelProperty(value = "部门Id",dataType = "string")
    private String fDepartId;
    @ApiModelProperty(value = "职位",dataType = "string")
    private String fPosition;
    @ApiModelProperty(value = "手机",dataType = "string",required = true)
    private String fMobile;
    @ApiModelProperty(value = "邮箱",dataType = "string")
    private String fEmail;
    @ApiModelProperty(value = "QQ",dataType = "string")
    private String fQq;
    @ApiModelProperty(value = "公司id",dataType = "long")
    private Long fCompanyId;
    //账号状态  open-开通 close-禁用
    @ApiModelProperty(value = "账号状态",dataType = "string")
    private String fStatus;
    //是否删除   yes-删除 no-未删除
    @ApiModelProperty(value = "是否删除",dataType = "string")
    private String fIsDelete;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
    }

    public String getfPosition() {
        return fPosition;
    }

    public void setfPosition(String fPosition) {
        this.fPosition = fPosition;
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

    public String getfQq() {
        return fQq;
    }

    public void setfQq(String fQq) {
        this.fQq = fQq;
    }

    public String getfMenus() {
        return fMenus;
    }

    public void setfMenus(String fMenus) {
        this.fMenus = fMenus;
    }

    public String getfDepartName() {
        return fDepartName;
    }

    public void setfDepartName(String fDepartName) {
        this.fDepartName = fDepartName;
    }

    public String getfDepartId() {
        return fDepartId;
    }

    public void setfDepartId(String fDepartId) {
        this.fDepartId = fDepartId;
    }

    public Long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(Long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    public String getfIsDelete() {
        return fIsDelete;
    }

    public void setfIsDelete(String fIsDelete) {
        this.fIsDelete = fIsDelete;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }
}
