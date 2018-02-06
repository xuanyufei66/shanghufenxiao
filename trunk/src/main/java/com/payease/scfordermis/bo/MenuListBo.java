package com.payease.scfordermis.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by admin on 2018/1/24.
 */
@ApiModel(value = "菜单权限集合类",description = "菜单权限集合实体类")
public class MenuListBo {
    @ApiModelProperty(value = "菜单权限集合")
    private List<MenuBo> list;

    public List<MenuBo> getList() {
        return list;
    }

    public void setList(List<MenuBo> list) {
        this.list = list;
    }
}
