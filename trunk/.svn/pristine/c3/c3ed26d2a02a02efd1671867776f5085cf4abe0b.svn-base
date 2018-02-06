package com.payease.scfordermis.controller.app.customer;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.ReqLoginClientBean;
import com.payease.scfordermis.bo.responseBo.RespLoginClientBean;
import com.payease.scfordermis.service.LoginClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhili on 2018/1/10.
 */
@RestController
@RequestMapping("app/customer/login")
@Api(tags = {"客户端 (APP)-登录-周世杰"})
public class AppCustomerLoginController extends AppCustomerBaseController {
    private static final Logger log = LoggerFactory.getLogger(AppCustomerLoginController.class);
    @Autowired
    LoginClientService loginClientService;


    @PostMapping(value = "clientlogin")
    @ApiOperation(value = "登录", response = RespLoginClientBean.class)
    public ResultBo login( ReqLoginClientBean req)throws Exception{
       return loginClientService.login(req);

//        ResultBo result =ResultBo.build();
//        RespLoginClientBean resp = new RespLoginClientBean();
//        resp.setToken("sahdjahfjahfhajhfakjhakl");
//        resp.setCompanyName("东盟水果商会");
//        List<Map<String,Object>> list = new ArrayList<>();
//        Map<String,Object> map = new HashMap<>();
//        map.put("imgUrl","www.baidu.com");
//        Map<String,Object> map1 = new HashMap<>();
//        map1.put("imgUrl","www.jd.com");
//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("imgUrl","www.sina.com");
//        Map<String,Object> map3 = new HashMap<>();
//        map3.put("imgUrl","www.taobao.com");
//        Map<String,Object> map4 = new HashMap<>();
//        map4.put("imgUrl","www.tmall.com");
//        list.add(map);
//        list.add(map1);
//        list.add(map2);
//        list.add(map3);
//        list.add(map4);
//        resp.setBanners(list);
//        result.setResultBody(resp);
//        return result;
    }


    @PostMapping(value = "clientautoLogin")
    @ApiOperation(value = "自动登录", response = RespLoginClientBean.class)
    public ResultBo autoLogin(String token) throws Exception{
        return loginClientService.autoLogin(token);
//        ResultBo result = ResultBo.build();
//        RespLoginClientBean resp = new RespLoginClientBean();
//        resp.setToken("sahdjahfjahfhajhfakjhakl");
//        resp.setCompanyName("东盟水果商会");
//        List<Map<String,Object>> list = new ArrayList<>();
//        Map<String,Object> map = new HashMap<>();
//        map.put("imgUrl","www.baidu.com");
//        Map<String,Object> map1 = new HashMap<>();
//        map1.put("imgUrl","www.jd.com");
//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("imgUrl","www.sina.com");
//        Map<String,Object> map3 = new HashMap<>();
//        map3.put("imgUrl","www.taobao.com");
//        Map<String,Object> map4 = new HashMap<>();
//        map4.put("imgUrl","www.tmall.com");
//        list.add(map);
//        list.add(map1);
//        list.add(map2);
//        list.add(map3);
//        list.add(map4);
//        resp.setBanners(list);
//        result.setResultBody(resp);
//        return result;
    }

    @GetMapping(value = "clientlogout")
    @ApiOperation(value = "登出",response = ResultBo.class)
    public ResultBo logout(String token) throws Exception{
        return loginClientService.logout(token);
//        ResultBo result = ResultBo.build();
//        return result;
    }



}
