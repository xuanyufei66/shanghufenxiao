package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by lch on 2018/1/10.
 * <p>
 * 销售地区返回对象
 */
@ApiModel(value = "销售地区", description = "销售地区下拉框")
public class RespAreaInfoBo {

    @ApiModelProperty(value = "id", dataType = "long")
    private Long fId;
    @ApiModelProperty(value = "销售地区", dataType = "string")
    private String fName;
    @ApiModelProperty(value = "地区级别（1-一级地区，2-二级地区）", dataType = "string")
    private String fLevel;
    @ApiModelProperty(value = "子地区（有子节点时才有值）", dataType = "list")
    private List<RespAreaInfoBo> respAreaInfoBoList;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfLevel() {
        return fLevel;
    }

    public void setfLevel(String fLevel) {
        this.fLevel = fLevel;
    }

    public List<RespAreaInfoBo> getRespAreaInfoBoList() {
        return respAreaInfoBoList;
    }

    public void setRespAreaInfoBoList(List<RespAreaInfoBo> respAreaInfoBoList) {
        this.respAreaInfoBoList = respAreaInfoBoList;
    }
}
