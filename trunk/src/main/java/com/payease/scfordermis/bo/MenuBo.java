package com.payease.scfordermis.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by admin on 2018/1/24.
 */
@ApiModel(value = "菜单权限",description = "菜单权限实体类")
public class MenuBo {
    @ApiModelProperty(value = "选中状态: true:选中 false:未选中")
    private Boolean  codeSelect;
    @ApiModelProperty(value = "菜单id")
    private String codeId;

    public Boolean getCodeSelect() {
        return codeSelect;
    }

    public void setCodeSelect(Boolean codeSelect) {
        this.codeSelect = codeSelect;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
