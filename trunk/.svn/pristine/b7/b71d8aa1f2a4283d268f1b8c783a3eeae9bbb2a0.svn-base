package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 上午10:55
 **/
@ApiModel(value = "员工列表查询实体带分页",description = "描述员工列表查询类带分页")
public class RespEmpListBean extends PageBean{
    @ApiModelProperty(value = "员工列表集合",dataType = "string",required = true)
    private List<RespEmpAccNumBean> list;

    public List<RespEmpAccNumBean> getList() {
        return list;
    }

    public void setList(List<RespEmpAccNumBean> list) {
        this.list = list;
    }

}
