package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhoushijie on 2018/1/11.
 * 入参
 */
@ApiModel(value = "销售区域新增修改入参",description = "描述销售区域新增修改入参")
public class ReqSaveSellAreaBean {
    @ApiModelProperty(value = "主键ID（新增：ID非必填 修改：ID必填）",dataType = "long")
    private Long fId;
    @ApiModelProperty(value = "上级区域ID（新增父节点：ParentId非必填 新增子节点：ParentId必填）",dataType = "long")
    private Long fParentId;
    @ApiModelProperty(value = "区域名称",dataType = "string",required = true)
    private String fName;

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
}
