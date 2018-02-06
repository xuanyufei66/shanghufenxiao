package com.payease.scfordermis.service;

import com.payease.scfordermis.bo.requestBo.GoodAddOrUpdateBo;
import com.payease.scfordermis.bo.responseBo.GoodUpdateShowBo;
import com.payease.scfordermis.bo.responseBo.GoodsManageBo;
import com.payease.scfordermis.bo.responseBo.QueryCategoryBo;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * Created by ljp on 2018/1/10.
 */
public interface IGoodsService {
    /**
     * 商品分类
     */
    //商品添加与修改接口
    public ResultBo categoryAddOrUpdate(Long id, String categoryName, Long categoryParentId, RespLoginPCBean respLoginPCBean);
    //商品分类删除接口
    public ResultBo categoryDelete(Long id);
    //商品分类列表
    public List<QueryCategoryBo> getCategoryList(Long companyId);
    /**
     * 计量单位
     */
    //新增计量单位
    public ResultBo unitAdd(String unitName,RespLoginPCBean respLoginPCBean);
    //删除计量单位
    public ResultBo unitDelete(Long id);
    //计量单位列表
    public ResultBo unitList(Long companyId);

    /**
     * 商品管理
     */
    //商品列表
    public Page<GoodsManageBo> getGoodsList(Long categoryId,String searchCondition, Integer page, Integer size,RespLoginPCBean respLoginPCBean);
    //显示商品修改信息接口
    public GoodUpdateShowBo getGoodsMessage(Long goodsId);
    //添加修改商品信息接口
    public void goodsAddOrUpdate(GoodAddOrUpdateBo goodAddOrUpdateBo,RespLoginPCBean respLoginPCBean);
    //删除商品
    public void goodsDelete(Long id);

}
