package com.payease.scfordermis.bo.responseBo;

import com.payease.scfordermis.entity.TCategoryInfoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by ljp on 2018/1/10.
 */
@ApiModel(value = "商品分类",description = "查询商品分类返回的类")
public class QueryCategoryBo {
    @ApiModelProperty(value = "分类id")
    private long fId;
    @ApiModelProperty(value = "分类名称",dataType = "string",required = true)
    private String fName;
    private List<TCategoryInfoEntity> childList;

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

    public List<TCategoryInfoEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<TCategoryInfoEntity> childList) {
        this.childList = childList;
    }



}
