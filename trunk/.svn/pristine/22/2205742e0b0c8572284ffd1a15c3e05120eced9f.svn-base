package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午3:27
 **/
@ApiModel(value = "员工角色列表",description = "员工角色列表")
public class RespEmpRoleInfoBean {
    @ApiModelProperty(value = "员工角色ID",dataType = "long",required = true)
    private long fId;
    @ApiModelProperty(value = "角色名称",dataType = "string",required = true)
    private String fName;
    @ApiModelProperty(value = "是否选中 1：选中 0：未选中 新增页面：全部未选中  修改页面、查看详情页面：根据员工角色关系表来做选中",dataType = "string",required = true)
    private Integer isCheck;

    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "RespEmpRoleInfoBean{" +
                "fId=" + fId +
                ", fName='" + fName + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}
