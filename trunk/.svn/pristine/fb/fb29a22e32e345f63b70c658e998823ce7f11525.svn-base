package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午2:02
 **/
public class PageBean {
    @ApiModelProperty(value = "当前页",dataType = "int",required = true)
    private Integer number;
    @ApiModelProperty(value =  "每页显示条数",dataType = "int",required = true)
    private Integer size;
    @ApiModelProperty(value =  "总条数",dataType = "int",required = true)
    private Integer totalElements;
    @ApiModelProperty(value =  "总页数",dataType = "int",required = true)
    private Integer totalPages;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "number=" + number +
                ", size=" + size +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                '}';
    }
}
