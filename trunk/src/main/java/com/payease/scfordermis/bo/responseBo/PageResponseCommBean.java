package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@ApiModel(value = "分页公共返回类",description = "描述分页返回类")
public class PageResponseCommBean<T> extends PageBean{
    @ApiModelProperty(value = "结果集",dataType = "list")
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageResponseCommBean{" +
                "content=" + content +
                '}';
    }
}
