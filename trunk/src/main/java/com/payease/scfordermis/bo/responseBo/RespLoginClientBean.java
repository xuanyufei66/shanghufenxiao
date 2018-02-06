package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by zhoushijie on 2018/1/11.
 * 出参
 */
@ApiModel(value = "登录客户端实体类",description = "登录客户端")
public class RespLoginClientBean {
    @ApiModelProperty(value = "token",dataType = "string",required = true)
    private String token;
    @ApiModelProperty(value = "公司名称",dataType = "string",required = true)
    private String companyName;
    @ApiModelProperty(value = "banners",dataType = "string",required = true)
    private List<Map<String,Object>> banners;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Map<String, Object>> getBanners() {
        return banners;
    }

    public void setBanners(List<Map<String, Object>> banners) {
        this.banners = banners;
    }
}
