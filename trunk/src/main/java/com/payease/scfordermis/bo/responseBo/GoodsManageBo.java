package com.payease.scfordermis.bo.responseBo;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ljp on 2018/1/9.
 */
public class GoodsManageBo {

    @ApiModelProperty(value = "商品id",dataType = "long")
    private Long goodsId;
    @ApiModelProperty(value = "水果主图",dataType = "string")
    private String picMain;
    /*@ApiModelProperty(value = "水果图片集合",dataType = "string")
    private String picAll;*/
    @ApiModelProperty(value = "商品名称",dataType = "string")
    private String goodsName;
    /*@ApiModelProperty(value = "商品编码",dataType = "string")
    private String goodsNo;*/
    @ApiModelProperty(value = "规格",dataType = "string")
    private String formatName;
    @ApiModelProperty(value = "单位",dataType = "string")
    private String unitName;
    @ApiModelProperty(value = "销售价",dataType = "string")
    private String price;
    @ApiModelProperty(value = "状态",dataType = "string")
    private String status;
    @ApiModelProperty(value = "商品分类",dataType = "string")
    private String categoryName;
    /*@ApiModelProperty(value = "商品标签",dataType = "string")
    private String label;*/

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

   /* public String getPicAll() {
        return picAll;
    }

    public void setPicAll(String picAll) {
        this.picAll = picAll;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }*/

    public String getPicMain() {
        return picMain;
    }

    public void setPicMain(String picMain) {
        this.picMain = picMain;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /*public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }*/
}
