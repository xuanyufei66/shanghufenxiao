package com.payease.scfordermis.bo.requestBo;

import com.payease.scfordermis.bo.responseBo.PageBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by admin on 2018/1/11.
 */
@ApiModel(value = "客户级别实体",description = "客户级别实体")
public class ReqConsumerLevelBean{
    @ApiModelProperty(value = "新增：fId为null 修改：fId不为null",dataType = "String",required = false)
    private  String  fId;

    @ApiModelProperty(value = "客户级别名称",dataType = "String",required = true)
    private  String  fName;

    @ApiModelProperty(value = "折扣",dataType = "String",required = false)
    private  String  fDiscount;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfDiscount() {
        return fDiscount;
    }

    public void setfDiscount(String fDiscount) {
        this.fDiscount = fDiscount;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }
}
