package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by zhangzhili on 2018/1/8.
 */
@ApiModel(value = "用户实体类",description = "描述用户实体类")
public class UserBean {

    @ApiModelProperty(value = "名字value",dataType = "string",required = true)
    private String name;
    @ApiModelProperty(value = "年龄value",dataType = "int")
    private Integer age;
    @ApiModelProperty(dataType = "date")
    private Date startTime;
    @ApiModelProperty(value = "金钱value",dataType = "double")
    private Double money;
    @ApiModelProperty(value = "long类型代表主键id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
