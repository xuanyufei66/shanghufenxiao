package com.payease.scfordermis.controller;



import com.payease.scfordermis.bo.*;
import com.payease.scfordermis.bo.responseBo.*;
import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.requestBo.GoodAddOrUpdateBo;
import com.payease.scfordermis.entity.TCategoryInfoEntity;
import com.payease.scfordermis.service.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * Created by ljp on 2018/1/9.
 */
@RestController
@RequestMapping("/goods")
@Api(tags = {"商品管理-----刘锦鹏"})
public class GoodsManageController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(GoodsManageController.class);

    @Autowired
    IGoodsService iGoodsService;

    /**
     * 商品分类
     **/
    @PostMapping(value = "categoryaddorupdate")
    @ApiOperation(value = "商品分类添加与修改接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fId", value = "商品id(当新增时id为空，当编辑时id不为空)", paramType = "query"),
            @ApiImplicitParam(name = "fName", value = "分类名称", paramType = "query"),
            @ApiImplicitParam(name = "fParentId", value = "商品分类的父id（一级分类的父id为0）", paramType = "query")
    })
    public ResultBo categoryAddOrUpdate(Long fId, String fName, Long fParentId) {
        log.info("请求商品分类添加与修改接口的入参id={},level={},categoryName={},categoryParentId={}", fId, fName, fParentId);
        putUserInfo();
        RespLoginPCBean respLoginPCBean = getUserInfo();
        return iGoodsService.categoryAddOrUpdate(fId, fName, fParentId, respLoginPCBean);
        //挡板
       /*ResultBo resultBo =ResultBo.build();
       return resultBo;*/
    }

    @DeleteMapping(value = "categorydetele")
    @ApiOperation(value = "商品分类删除接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fId", value = "分类id", paramType = "query")
    })
    public ResultBo categoryDelete(Long fId) {
        log.info("商品分类的删除的入参={}", fId);
        return iGoodsService.categoryDelete(fId);
        //挡板
        /*ResultBo resultBo = ResultBo.build();
        return resultBo;*/
    }

    @GetMapping(value = "categorylist")
    @ApiOperation(value = "商品分类列表", response = QueryCategoryBo.class)
    public ResultBo getCategoryList() {
       /* ResultBo result = ResultBo.build();
        List<QueryCategoryBo> listParent = new ArrayList<>();
        List<TCategoryInfoEntity> listChild = new ArrayList<>();

        QueryCategoryBo categoryBoParent = new QueryCategoryBo();
        categoryBoParent.setfId(1);
        categoryBoParent.setfName("水果生鲜");

        TCategoryInfoEntity tCategoryInfoEntity = new TCategoryInfoEntity();
        tCategoryInfoEntity.setfId(2);
        tCategoryInfoEntity.setfName("越南水果");
        tCategoryInfoEntity.setfParentId(1);
        listChild.add(tCategoryInfoEntity);
        TCategoryInfoEntity tCategoryInfoEntity1 = new TCategoryInfoEntity();
        tCategoryInfoEntity1.setfId(3);
        tCategoryInfoEntity.setfParentId(1);
        tCategoryInfoEntity1.setfName("天津水果");
        listChild.add(tCategoryInfoEntity1);

        categoryBoParent.setChildList(listChild);//泛型改了
        listParent.add(categoryBoParent);
        result.setResultBody(listParent);
        return result;*/

        putUserInfo();
        RespLoginPCBean respLoginPCBean = getUserInfo();
        ResultBo result = ResultBo.build();
        List<QueryCategoryBo> categoryList = iGoodsService.getCategoryList(respLoginPCBean.getfCompanyId());
        result.setResultBody(categoryList);
        return result;
    }

    /**
     * 计量单位
     */
    @GetMapping(value = "unitlist")
    @ApiOperation(value = "计量单位列表", response = UnitBo.class)
    public ResultBo unitList() {
       /* ResultBo result = ResultBo.build();
        List<UnitBo> unitLists = new ArrayList<>();
        UnitBo unitBo1 = new UnitBo();
        unitBo1.setfId(1l);
        unitBo1.setfName("KG");
        UnitBo unitBo2 = new UnitBo();
        unitBo2.setfId(2l);
        unitBo2.setfName("吨");
        unitLists.add(unitBo1);
        unitLists.add(unitBo2);
        result.setResultBody(unitLists);
        return result;*/

        putUserInfo();
        RespLoginPCBean respLoginPCBean = getUserInfo();
        return iGoodsService.unitList(respLoginPCBean.getfCompanyId());
    }

    @PostMapping(value = "unitadd")
    @ApiOperation(value = "新增计量单位接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "计量单位", paramType = "query")
    })
    public ResultBo unitAdd(String name) {
       /* ResultBo result = ResultBo.build();
        return result;*/
        putUserInfo();
        RespLoginPCBean respLoginPCBean = getUserInfo();
        return iGoodsService.unitAdd(name,respLoginPCBean);
    }

    @DeleteMapping(value = "unitdelete")
    @ApiOperation(value = "删除计量单位")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "计量单位id", paramType = "query")
    })
    public ResultBo unitDelete(Long id) {
        /*ResultBo result = ResultBo.build();
        return result;*/
        return iGoodsService.unitDelete(id);
    }

    /**
     * 商品管理
     */
    @GetMapping(value = "goodslist")
    @ApiOperation(value = "商品列表", response = GoodsManageBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类id", paramType = "query"),
            @ApiImplicitParam(name = "searchCondition", value = "商品名称/编码/关键字/规格", paramType = "query", dataType = "string"),
    })
    public ResultBo getGoodsList(Long categoryId,String searchCondition, PageBean pageBean) {
        //挡板
        /*ResultBo result = ResultBo.build();
        GoodsManageBo goodsManageBo = new GoodsManageBo();
        goodsManageBo.setGoodsId(1L);
        goodsManageBo.setPicMain("www.baidu.com/shuiguo");
        goodsManageBo.setGoodsName("越南金山榴莲");
        goodsManageBo.setFormatName("A果，B果，C果");
        goodsManageBo.setUnitName("KG");
        goodsManageBo.setPrice("8.00");
        goodsManageBo.setStatus("1200");
        goodsManageBo.setCategoryName("越南水果");

        GoodsManageBo goodsManageBo1 = new GoodsManageBo();
        goodsManageBo1.setGoodsId(2L);
        goodsManageBo1.setPicMain("www.baidu.com/shuiguo");
        goodsManageBo1.setGoodsName("越南大芒果");
        goodsManageBo1.setFormatName("优等，普通");
        goodsManageBo1.setUnitName("KG");
        goodsManageBo1.setPrice("7.00");
        goodsManageBo1.setStatus("2000");
        goodsManageBo1.setCategoryName("越南水果");

        List<GoodsManageBo> goodsManageBoList = new ArrayList<>();
        goodsManageBoList.add(goodsManageBo);
        goodsManageBoList.add(goodsManageBo1);

        PageResponseCommBean pageResponseCommBean = new PageResponseCommBean();
        pageResponseCommBean.setNumber(3);
        pageResponseCommBean.setSize(1);
        pageResponseCommBean.setTotalElements(6);
        pageResponseCommBean.setTotalPages(2);
        pageResponseCommBean.setContent(goodsManageBoList);
        result.setResultBody(pageResponseCommBean);
        return result;*/
        putUserInfo();
        ResultBo resultBo = ResultBo.build();
        RespLoginPCBean respLoginPCBean = getUserInfo();
        Page<GoodsManageBo> goodsList = iGoodsService.getGoodsList(categoryId,searchCondition, pageBean.getPage(), pageBean.getSize(), respLoginPCBean);
        resultBo.setResultBody(goodsList);
        return resultBo;
    }

    @GetMapping(value = "goodsupdateshow")
    @ApiOperation(value = "显示商品修改信息接口", response = GoodUpdateShowBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品id", paramType = "query",required = true),
    })
    public ResultBo getGoodsShow(Long goodsId) {
        //挡板
       /* ResultBo result = ResultBo.build();
        List<ProductFormatBo> formatList = new ArrayList<>();
        ProductFormatBo productFormatBo = new ProductFormatBo();
        productFormatBo.setFormatId(2L);
        productFormatBo.setPicMain("www.baidu.com");
        productFormatBo.setFormatName("普通");
        productFormatBo.setGoodsNo("P02012542");
        productFormatBo.setGoodsPrice("100.00");
        ProductFormatBo productFormatBo1 = new ProductFormatBo();
        productFormatBo1.setFormatId(3L);
        productFormatBo1.setPicMain("www.tianjin.com");
        productFormatBo1.setFormatName("优等");
        productFormatBo1.setGoodsNo("P0200000");
        productFormatBo1.setGoodsPrice("100.00");
        formatList.add(productFormatBo);
        formatList.add(productFormatBo1);

        GoodUpdateShowBo goodUpdateShowBo = new GoodUpdateShowBo();
        goodUpdateShowBo.setGoodsId(1L);
        goodUpdateShowBo.setGoodsName("越南菠萝");
        goodUpdateShowBo.setfCategoryId(1L);
        goodUpdateShowBo.setfCategoryName("越南水果");
        goodUpdateShowBo.setfUnitId(1L);
        goodUpdateShowBo.setfStatus("up");
        goodUpdateShowBo.setFormatList(formatList);
        goodUpdateShowBo.setfDesp("水果，新鲜的水果。");
        result.setResultBody(goodUpdateShowBo);
        return result;*/

        ResultBo resultBo = ResultBo.build();
        GoodUpdateShowBo goodsMessage = iGoodsService.getGoodsMessage(goodsId);
        resultBo.setResultBody(goodsMessage);
        return resultBo;
    }

    @PostMapping(value = "goodsaddorupdate")
    @ApiOperation(value = "添加修改商品信息接口")
    public ResultBo getGoodsAddOrUpdate(GoodAddOrUpdateBo goodAddOrUpdateBo1) {
        //挡板
        /*ResultBo result = ResultBo.build();
        return result;*/
        putUserInfo();
        ResultBo result = ResultBo.build();
        RespLoginPCBean respLoginPCBean = getUserInfo();
        iGoodsService.goodsAddOrUpdate(goodAddOrUpdateBo1,respLoginPCBean);
        return result;
    }

    @DeleteMapping(value = "goodsdelete")
    @ApiOperation(value = "删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品id", paramType = "query", dataType = "Long"),
    })
    public ResultBo getGoodDelete(Long goodsId) {
        /*ResultBo result = ResultBo.build();
        return result;*/
        ResultBo result = ResultBo.build();
        iGoodsService.goodsDelete(goodsId);
        return result;

    }

}
