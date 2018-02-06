package com.payease.scfordermis.controller.app.driver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.app.driver.RespAppDriverUserBean;
import com.payease.scfordermis.entity.TCompanyInfoEntity;
import com.payease.scfordermis.entity.TTransportOrderEntity;
import com.payease.scfordermis.service.AppDriverLoginService;
import com.payease.scfordermis.service.AppDriverSendLoginCodeService;
import com.payease.scfordermis.service.CompanyInfoService;
import com.payease.scfordermis.service.TransportService;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhili on 2018/1/10.
 * desc:司机登录
 */
@RestController
@RequestMapping("app/driver")
@Api(tags = {"app司机端登录模块  Created by zhangzhili"})
public class AppDriverLoginController extends AppDriverBaseController{

     @Autowired
     private AppDriverSendLoginCodeService appDriverSendLoginCodeService;
    @Autowired
    private AppDriverLoginService appDriverLoginService;
    @Autowired
    CompanyInfoService companyInfoService;
    @Autowired
    TransportService transportService;
    @Autowired
    StringRedisTemplate redis;//获取Redis



    @GetMapping("sendsms")
    @ApiOperation(value = "发送短信验证码")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone", value = "手机号", paramType = "query", required = true),
            @ApiImplicitParam(name = "smsType", value = "发送场景 dirverLogin:司机端登录 misLogin:客户端登录", paramType = "query",
            required = true)})
    public ResultBo sendLoginCode(String phone,String smsType) {
        ResultBo resultBo = ResultBo.build();
//        Map<String, String> map = new HashMap();
//        map.put("code", "5432");
//        resultBo.setResultBody(map);
        try {
            resultBo =appDriverSendLoginCodeService.sendLoginCode(phone,smsType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBo;
    }

    @PostMapping("login")
    @ApiOperation(value = "登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "手机号", paramType = "query",
        required = true), @ApiImplicitParam(name = "code", value = "短信验证码", paramType = "query",
        required = true)})
    public ResultBo login(String username, String code)throws Exception {
        return appDriverLoginService.login(username,code);
//        ResultBo resultBo = ResultBo.build();
//        Map<String, String> map = new HashMap();
//        map.put("token", "HGFDSASDFGHGFDSDFGHGFD8765432");
//        resultBo.setResultBody(map);
//        return resultBo;
    }
    @PostMapping("autoLogin")
    @ApiOperation(value = "自动登录")
    @ApiImplicitParam(name = "token", value = "token", paramType = "query", required = true)
    public ResultBo autoLogin(String token) throws Exception{
        return appDriverLoginService.autoLogin(token);
//        ResultBo resultBo = ResultBo.build();
//        Map<String, String> map = new HashMap();
//        map.put("token", "HGFDSASDFGHGFDSDFGHGFD8765432");
//        resultBo.setResultBody(map);
//        return resultBo;
    }

    @PostMapping("logout")
    @ApiOperation(value = "退出")
    @ApiImplicitParam(name = "token", value = "token", paramType = "query", required = true)
    public ResultBo logout(String token) throws Exception{
        return appDriverLoginService.logout(token);
//        ResultBo resultBo = ResultBo.build();
//        return resultBo;
    }



    @GetMapping("getuserinfo")
    @ApiOperation(value = "获取用户信息",response = RespAppDriverUserBean.class)
    @ApiImplicitParam(name = "token", value = "token", paramType = "query", required = true)
    public ResultBo getUserInfo(String token){
        ResultBo result = ResultBo.build();
        String userJson = String.valueOf(redis.opsForValue().get(token));
        JSONObject bodyJson = JSON.parseObject(userJson);
        String fTransportOrderId = bodyJson.getString("id");//运单id
        String fCompanyId = bodyJson.getString("fCompanyId");//公司id
        if (StringUtils.isNotBlank(fTransportOrderId) && StringUtils.isNotBlank(fCompanyId)){
            TCompanyInfoEntity tCompanyInfoEntity = companyInfoService.findCompanyById(Long.valueOf(fCompanyId));//根据公司id获取公司信息
            TTransportOrderEntity transportOrderEntity =transportService.findTramsById(Long.valueOf(fTransportOrderId));//根据运单id获取司机信息
            RespAppDriverUserBean respAppDriverUserBean = new RespAppDriverUserBean();
            respAppDriverUserBean.setDriverName(transportOrderEntity.getfDriverName());//司机姓名
            respAppDriverUserBean.setDriverPhone(transportOrderEntity.getfDriverPhone());//司机电话
            respAppDriverUserBean.setMerchantPhone(tCompanyInfoEntity.getfServiceNumber());//商家手机号
            result.setResultBody(respAppDriverUserBean);
            return result;
        }else {
            return result.setCodeId(Status.NOQUALIFIEDVALUE);
        }
    }
    //@GetMapping("getuserinfo")
    //@ApiOperation(value = "获取用户信息")
    //@ApiImplicitParam(name = "token", value = "token", paramType = "query", required = true)
    //public ResultBo getUserInfo(String token){
    //    ResultBo resultBo = ResultBo.build();
    //
    //    RespAppDriverUserBean respAppDriverUserBean = new RespAppDriverUserBean();
    //    respAppDriverUserBean.setDriverName("张三");
    //    respAppDriverUserBean.setDriverPhone("18502102012");
    //    respAppDriverUserBean.setMerchantPhone("4006311887");
    //    resultBo.setResultBody(respAppDriverUserBean);
    //    return resultBo;
    //
    //}

}
