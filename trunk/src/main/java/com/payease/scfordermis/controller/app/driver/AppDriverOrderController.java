package com.payease.scfordermis.controller.app.driver;

import com.google.common.collect.Maps;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppDriverLoginBean;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppGoodBean;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppOrderBean;
import com.payease.scfordermis.controller.app.customer.AppCustomerOrderController;
import com.payease.scfordermis.service.AppDriverLoginService;
import com.payease.scfordermis.service.IAppOrderService;
import com.payease.scfordermis.service.LoginClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@RestController
@RequestMapping("app/driver/order")
@Api(tags = {"app司机端订单业务处理模块  Created by zhangzhili"})
public class AppDriverOrderController extends AppDriverBaseController {

    private static final Logger log = LoggerFactory.getLogger(AppDriverOrderController.class);

    @Autowired
    AppDriverLoginService appDriverLoginService;
    @Autowired
    LoginClientService loginClientService;
    @Autowired
    IAppOrderService appOrderService;

    @GetMapping("getorders")
    @ApiOperation(value = "订单列表", response = RespAppOrderBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "orderStatus", value =
        "1-待提货／不传-所有", dataType = "string", paramType = "query")})
    public ResultBo getOrderList(String token, Long orderStatus) {
        ResultBo resultBo = ResultBo.build();
        try {
            RespAppDriverLoginBean userInfo = getDriverUserInfo(appDriverLoginService, token);
            resultBo.setResultBody(appOrderService.driverOrders(userInfo.getfCompanyId(),
                orderStatus, userInfo.getId()));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }



    @GetMapping("getorderdetail")
    @ApiOperation(value = "订单详情", response = RespAppOrderBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true)})
    public ResultBo getOrderDetail(String token, Long id) {
        ResultBo resultBo = ResultBo.build();

        try {
            RespAppDriverLoginBean userInfo = getDriverUserInfo(appDriverLoginService, token);
            resultBo.setResultBody(appOrderService.getDriverOrderDetail(userInfo.getId(), id));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;

    }



    @GetMapping("scanning")
    @ApiOperation(value = "二维码扫描请求接口／提货码请求接口", response = RespAppOrderBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "orderscan", value =
        "提货码", dataType = "string", paramType = "query", required = true),})
    public ResultBo getOrderScanning(String token, String orderscan) {
        ResultBo resultBo = ResultBo.build();

        try {
            RespAppDriverLoginBean userInfo = getDriverUserInfo(appDriverLoginService, token);
            resultBo.setResultBody(appOrderService.getScanPickCode(userInfo.getfCompanyId(),
                userInfo.getfTransportNum(), userInfo.getId(), orderscan));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }


    @GetMapping("getpickupgoods")
    @ApiOperation(value = "确认提货")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true)})
    public ResultBo getPickUpGoods(String token, Long id) {
        ResultBo resultBo = ResultBo.build();
        try {

            RespAppDriverLoginBean userInfo = getDriverUserInfo(appDriverLoginService, token);
            Map<String, String> map = Maps.newHashMap();
            map.put("orderNum", appOrderService.pickGoods(userInfo.getId(), id));
            resultBo.setResultBody(map);
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }


}
