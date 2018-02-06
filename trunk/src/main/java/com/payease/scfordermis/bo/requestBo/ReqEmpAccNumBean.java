package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 上午10:45
 **/
@ApiModel(value = "员工账号列表查询实体类",description = "描述员工账号列表查询")
public class ReqEmpAccNumBean extends PageBean{

    @ApiModelProperty(value = "部门父ID： 0：一级部门",dataType = "int")
    private Integer depParentId;
    @ApiModelProperty(value = "部门ID： -1：查全部",dataType = "int")
    private Integer departmentId;
    @ApiModelProperty(value =  "员工姓名/账号/手机/职位",dataType = "string")
    private String other;

    /**
     * 返回当前的json字符串
     * @return
     */
    public Map<String, Object> getMap(){
        Map<String,Object> json=new HashMap<>();
        json.put("depParentId",depParentId);
        json.put("departmentId", departmentId);
        json.put("other", other);
        json.put("page",super.page);
        json.put("size",super.size);
        //return JSONObject.toJSONString(json);
        return json;
    }

    public Integer getDepParentId() {
        return depParentId;
    }

    public void setDepParentId(Integer depParentId) {
        this.depParentId = depParentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
