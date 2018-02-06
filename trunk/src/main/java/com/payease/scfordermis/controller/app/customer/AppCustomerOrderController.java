package com.payease.scfordermis.controller.app.customer;

import com.payease.scfordermis.bean.PageRequest;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.PageBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.bo.responseBo.RespOperationLogBo;
import com.payease.scfordermis.bo.responseBo.RespRemarkBo;
import com.payease.scfordermis.bo.responseBo.app.customer.RespAppCustomerOrderBean;
import com.payease.scfordermis.bo.responseBo.app.customer.RespAppCustomerOrderDetailBean;
import com.payease.scfordermis.bo.responseBo.app.customer.RespAppPayDetailBean;
import com.payease.scfordermis.bo.responseBo.app.customer.RespAppPayHistoryBean;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppGoodBean;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppOrderBean;
import com.payease.scfordermis.entity.TConsumerInfoEntity;
import com.payease.scfordermis.entity.TOrderEntity;
import com.payease.scfordermis.entity.TPaymentHistoryEntity;
import com.payease.scfordermis.service.IAppOrderService;
import com.payease.scfordermis.service.LoginClientService;
import com.payease.scfordermis.utils.PayCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@RestController
@RequestMapping("app/customer/order")
@Api(tags = {"app客户端订单业务处理模块 Created by zhangzhili"})
public class AppCustomerOrderController extends AppCustomerBaseController {
    private static final Logger log = LoggerFactory.getLogger(AppCustomerOrderController.class);

    @Autowired
    IAppOrderService appOrderService;
    @Autowired
    LoginClientService loginClientService;

    @GetMapping("listorders")
    @ApiOperation(value = "订单列表查询", response = RespAppCustomerOrderBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "orderType", value =
        "订单标识0-所有订单；1-未完成订单", dataType = "string", paramType = "query", required = true)})
    public ResultBo ordersList(String token, int orderType, PageBean pageBean) {
        ResultBo resultBo = ResultBo.build();
        try {
            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            resultBo.setResultBody(appOrderService.findAllOrderNotComplete(userInfo.getfCompanyId
                (), orderType, PageRequest.of(pageBean.getPage(), pageBean.getSize())));

        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }



    @GetMapping("orderdetail")
    @ApiOperation(value = "订单详情", response = RespAppCustomerOrderDetailBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true),})
    public ResultBo orderDetail(String token, Long id) {

        ResultBo resultBo = ResultBo.build();
        try {

            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            resultBo.setResultBody(appOrderService.getOrderDetail(userInfo.getfCompanyId(), id));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);

        }
        return resultBo;
    }



    @Deprecated
    //    @GetMapping("getorderdetail/{id}")
    //    @ApiOperation(value = "商品清单", response = RespAppOrderBean.class)
    //    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType =
    // "string",
    //        paramType = "query", required = true), @ApiImplicitParam(name = "id", value =
    // "订单id",
    //        dataType = "string", paramType = "path", required = true)})
    public ResultBo getOrderDetail(String token, Long id) {
        ResultBo resultBo = ResultBo.build();


        RespAppOrderBean respAppOrderBean = new RespAppOrderBean();
        respAppOrderBean.setOrderId(2L);
        respAppOrderBean.setCustomerName("北京新发地水果商户");
        respAppOrderBean.setOrderNum("DH-20171219-678219");
        respAppOrderBean.setProductCategoryNum(2);
        respAppOrderBean.setProductNum(2000);
        respAppOrderBean.setStatus("待提货");
        List<RespAppGoodBean> list = new ArrayList<>();
        RespAppGoodBean respAppGoodBean = new RespAppGoodBean();
        respAppGoodBean.setImgUrl("http://overseatesco.yizhifubj"
            + ".com:8091/group1/M00/00/00/rBW07VpS2euAadb8AAAt8oApJbw968.jpg");
        respAppGoodBean.setFormateName("A果");
        respAppGoodBean.setGoodName("泰国进口金枕头榴莲");
        respAppGoodBean.setGoodNum(1000);
        respAppGoodBean.setUnitName("KG");
        list.add(respAppGoodBean);
        respAppOrderBean.setGoodBeanList(list);

        resultBo.setResultBody(respAppOrderBean);
        return resultBo;

    }



    @GetMapping("getpaydetail")
    @ApiOperation(value = "支付详情", response = RespAppPayDetailBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true)})
    public ResultBo getPayDetail(String token, Long id) {
        ResultBo resultBo = ResultBo.build();

        try {
            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            resultBo.setResultBody(appOrderService.getPayDetails(userInfo.getfCompanyId(), id));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;

    }



    @GetMapping("topay")
    @ApiOperation(value = "去支付", response = RespAppPayDetailBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true)})
    public ResultBo toPay(String token, Long id) {
        ResultBo resultBo = ResultBo.build();
        try {
            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            resultBo.setResultBody(appOrderService.getOrderMount(userInfo.getfCompanyId(), id));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }



    @GetMapping("agreement")
    @ApiOperation(value = "去签赊销协议", response = RespAppPayDetailBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true)})
    public ResultBo agreement(String token, Long id) {
        ResultBo resultBo = ResultBo.build();
        try {
            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            resultBo.setResultBody(appOrderService.makeAgreement(userInfo.getfName(), userInfo
                .getfCompanyId(), id));
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }



    @GetMapping("getpickcode")
    @ApiOperation(value = "获取提货码", response = RespAppOrderBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
        paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
        dataType = "string", paramType = "query", required = true)})
    public ResultBo getPickCode(String token, Long id) {
        ResultBo resultBo = ResultBo.build();
        try {
            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            resultBo.setResultBody(appOrderService.getPickCode(userInfo.getfName(), userInfo
                .getfCompanyId(), id));

        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }



    @Deprecated
    //    @GetMapping("getorderremarks/{id}")
    //    @ApiOperation(value = "获取订单备注", response = RespRemarkBo.class)
    //    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType =
    // "string",
    //        paramType = "query", required = true), @ApiImplicitParam(name = "id", value =
    // "订单id",
    //        dataType = "string", paramType = "path", required = true)})
    public ResultBo getOrderRemarks(String token, Long id) {

        ResultBo resultBo = ResultBo.build();
        List<RespRemarkBo> respRemarkBoList = new ArrayList<>();
        RespRemarkBo respRemarkBo = new RespRemarkBo();
        respRemarkBo.setfContent("请尽快发货哦");
        respRemarkBo.setfCreatetime("2018-01-01 12:12:12");
        respRemarkBo.setOperator("张海军");
        respRemarkBoList.add(respRemarkBo);
        resultBo.setResultBody(respRemarkBoList);
        return resultBo;

    }



    @Deprecated
    //    @GetMapping("getordernotes/{id}")
    //    @ApiOperation(value = "获取订单日志信息", response = RespOperationLogBo.class)
    //    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType =
    // "string",
    //        paramType = "query", required = true), @ApiImplicitParam(name = "id", value =
    // "订单id",
    //        dataType = "string", paramType = "path", required = true)})
    public ResultBo getOrdernotes(String token, Long id) {

        ResultBo resultBo = ResultBo.build();
        List<RespOperationLogBo> respRemarkBoList = new ArrayList<>();
        RespOperationLogBo respOperationLogBo = new RespOperationLogBo();
        respOperationLogBo.setfCreatetime("2018-01-01 12:12:12");
        respOperationLogBo.setfNote("订货单已通过出库审核，待发货");
        respOperationLogBo.setfOperator("张海军");
        respRemarkBoList.add(respOperationLogBo);
        resultBo.setResultBody(respRemarkBoList);
        return resultBo;

    }
    @GetMapping("topayment")
    @ApiOperation(value = "模拟支付", response = ResultBo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token标识", dataType = "string",
            paramType = "query", required = true), @ApiImplicitParam(name = "id", value = "订单id",
            dataType = "string", paramType = "query", required = true), @ApiImplicitParam(name = "money", value = "支付金额",
            dataType = "string", paramType = "query", required = true)})
    public ResultBo topayment(String token, Long id, BigDecimal money) {
        ResultBo resultBo = ResultBo.build();
        try {
            TConsumerInfoEntity userInfo = getUserInfo(loginClientService, token);
            TOrderEntity orderEntity = appOrderService.getOrderPublic(userInfo.getfCompanyId(), id);
            int result = appOrderService.updateOrder(id,userInfo.getfCompanyId(),money.add(orderEntity.getfPaidMoney()));
            TPaymentHistoryEntity paymentHistory = new TPaymentHistoryEntity();
            if(result==1){
                paymentHistory.setfPayNum(PayCode.payCode());
                paymentHistory.setfCreatetime(new Date());
                paymentHistory.setfAmount(money);
                paymentHistory.setfPaymethod("bankCard");
                paymentHistory.setfPayStatus("success");
                paymentHistory.setfCompanyId(userInfo.getfCompanyId());
                paymentHistory.setfOrderId(id);
            }else{
                paymentHistory.setfPayNum(PayCode.payCode());
                paymentHistory.setfCreatetime(new Date());
                paymentHistory.setfAmount(money);
                paymentHistory.setfPaymethod("bankCard");
                paymentHistory.setfPayStatus("faild");
                paymentHistory.setfCompanyId(userInfo.getfCompanyId());
                paymentHistory.setfOrderId(id);
            }

            result = appOrderService.savePaymentHistory(paymentHistory);
            if(result==1){
                resultBo.setMessage("支付成功");
            }else{
                resultBo.setCodeId(-1);
                resultBo.setMessage("支付失败");
            }
        } catch (Exception e) {
            log.error("处理异常", e);
            resultBo.errorHandle(e);
        }
        return resultBo;
    }

}
