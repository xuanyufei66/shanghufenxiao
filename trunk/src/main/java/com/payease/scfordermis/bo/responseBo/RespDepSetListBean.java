package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 上午10:55
 **/
@ApiModel(value = "部门设置列表实体",description = "描述部门设置列表")
public class RespDepSetListBean{

    @ApiModelProperty(value = "主键ID",dataType = "long")
    private Long fId;
    @ApiModelProperty(value = "上级部门ID:一级部门父节点为0",dataType = "long")
    private Long fParentId;
    @ApiModelProperty(value = "部门名称",dataType = "string")
    private String fName;

    @ApiModelProperty(value = "部门设置集合",dataType = "string")
    private List<RespDepSetListBean> childList;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Long getfParentId() {
        return fParentId;
    }

    public void setfParentId(Long fParentId) {
        this.fParentId = fParentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public List<RespDepSetListBean> getChildList() {
        return childList;
    }

    public void setChildList(List<RespDepSetListBean> childList) {
        this.childList = childList;
    }
}
