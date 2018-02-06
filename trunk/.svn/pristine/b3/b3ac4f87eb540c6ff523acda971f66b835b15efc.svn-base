package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 上午10:45
 **/
@ApiModel(value = "分页实体类",description = "描述分页实体类")
public class PageBean {
    @ApiModelProperty(value = "当前页(默认为1)",dataType = "int")
    public int page = 1;
    @ApiModelProperty(value = "每页显示条数（默认为10）",dataType = "int")
    public int size = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
