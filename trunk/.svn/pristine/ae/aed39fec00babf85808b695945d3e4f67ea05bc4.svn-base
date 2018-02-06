package com.payease.scfordermis.controller.app.customer;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqMsgListBean;
import com.payease.scfordermis.bo.responseBo.app.customer.RespMsgBean;
import com.payease.scfordermis.bo.responseBo.app.customer.RespMsgUnReadBean;
import com.payease.scfordermis.service.AppCustomerMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created By liuxiaoming
 * @CreateTime 2018/1/10 下午4:59
 **/
@RestController
@RequestMapping("app/customer/message")
@Api(tags = {"客户端（app）-消息-刘晓明"})
public class AppCustomerMsgController {

    @Autowired
    private AppCustomerMsgService appCustomerMsgService;
    @GetMapping(value = "unReadMsg")
    @ApiOperation(value = "未读消息个数",response = RespMsgUnReadBean.class)
    public ResultBo unReadMsg(String token) throws Exception{
        return appCustomerMsgService.unReadMsg(token);
//        ResultBo result = ResultBo.build();
//
//        RespMsgUnReadBean resp = new RespMsgUnReadBean();
//        resp.setUnReadMsgNum(2);
//        resp.setfMsgType("order");
//
//        result.setResultBody(resp);
//        return result;
    }

    //todo 消息状态修改接口  入参 页面跳转
    @PostMapping(value = "updMsgStatus")
    @ApiOperation(value = "消息状态修改",response = ResultBo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "msgId",value = "消息ID： 若传-1：全部已读",paramType = "query",required = true)
    })
    public ResultBo updMsgStatus(String token, Long msgId) throws Exception{
        return appCustomerMsgService.updMsgStatus(token, msgId);
//        ResultBo result = ResultBo.build();
//        return result;
    }


    @GetMapping(value = "msgList")
    @ApiOperation(value = "消息列表",response = RespMsgBean.class)
    public ResultBo msgList(String token,ReqMsgListBean req) throws Exception{
        return appCustomerMsgService.msgList(token, req);
//        ResultBo result = ResultBo.build();
//        PageResponseCommBean resp = new PageResponseCommBean();
//        List<RespMsgBean> list = new ArrayList<>();
//        RespMsgBean bean1 = new RespMsgBean();
//        RespMsgBean bean2 = new RespMsgBean();
//
//        bean1.setfId(Long.valueOf(1));
//        bean1.setOrderId(Long.valueOf(1));
//        bean1.setfMsgTitle("订单提货");
//        bean1.setfMsgDesc("您的订单已提货，订单号123456789");
//        bean1.setMsgTime(new Date());
//        bean1.setfMsgType("order");
//        bean1.setfMsgStatus("read");
//
//        bean2.setfId(Long.valueOf(2));
//        bean2.setOrderId(Long.valueOf(2));
//        bean2.setfMsgTitle("订单提货");
//        bean2.setfMsgDesc("您的订单已提货，订单号123456780");
//        bean2.setMsgTime(new Date());
//        bean2.setfMsgType("order");
//        bean2.setfMsgStatus("unread");
//
//        list.add(bean1);
//        list.add(bean2);
//
//        resp.setContent(list);
//        resp.setContent(list);
//        resp.setNumber(1);
//        resp.setSize(5);
//        resp.setTotalElements(1);
//        resp.setTotalPages(1);
//
//        result.setResultBody(resp);
//        return result;
    }


}
