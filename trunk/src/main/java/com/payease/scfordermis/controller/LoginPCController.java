package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqLoginPCBean;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import com.payease.scfordermis.service.LoginPCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by zhoushijie on 2018/1/11.
 */
@RestController
@RequestMapping("/loginweb")
@Api(tags = {"登录PC页面-周世杰"})
public class LoginPCController {
    @Autowired
    private LoginPCService loginPCService;
    private static final Logger log = LoggerFactory.getLogger(LoginPCController.class);


    @PostMapping(value = "/login")
    @ApiOperation(value = "登录",response = RespLoginPCBean.class)
    public ResultBo login(HttpSession session,ReqLoginPCBean reqLoginPCBean)throws Exception{

          return loginPCService.login(session, reqLoginPCBean);
//        ResultBo result = ResultBo.build();
//        RespLoginPCBean resp=new RespLoginPCBean();
//        resp.setfName("zhangsan");
//        resp.setfMenus("[\"1\",\"2\",\"3\",\"4\"]");
//        resp.setfAccount("222");
//        resp.setfDepartId("2");
//        resp.setfDepartName("华东大区公司");
//        resp.setfPosition("业务经理");
//        resp.setfName("zhangsan");
//        resp.setfMobile("189208821839719");
//        resp.setfEmail("1asdksaj@qq.com");
//        resp.setfQq("404812357");
//        result.setResultBody(resp);
//        return result;

    }

    @PostMapping(value = "/logout")
    @ApiOperation(value = "登出",response = ResultBo.class)
    public ResultBo logout(HttpSession session) throws Exception{
//        ResultBo result = ResultBo.build();
//        return result;
        return loginPCService.logout(session);
    }


}
