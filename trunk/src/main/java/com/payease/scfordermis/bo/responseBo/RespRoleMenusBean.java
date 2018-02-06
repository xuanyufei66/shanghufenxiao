package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午4:48
 **/
@ApiModel(value = "角色权限明细",description = "角色权限明细")
public class RespRoleMenusBean {
    @ApiModelProperty(value = "菜单权限",dataType = "string",required = true)
    private String roleMenus;

    public String getRoleMenus() {
        return roleMenus;
    }

    public void setRoleMenus(String roleMenus) {
        this.roleMenus = roleMenus;
    }
}
