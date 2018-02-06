package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by lch on 2018/1/17.
 * <p>
 * controller基础，用来获取session中的userInfo
 */
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(GoodsManageController.class);

    public static final String USERINFO = "userInfo";

    public HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest().getSession();
    }

    public void putUserInfo() {
        RespLoginPCBean respLoginPCBean = new RespLoginPCBean();
        respLoginPCBean.setfId(1l);
        respLoginPCBean.setfName("张三");
        respLoginPCBean.setfCompanyId(1l);
        getSession().setAttribute(USERINFO, respLoginPCBean);
    }

    public RespLoginPCBean getUserInfo() {
        RespLoginPCBean respLoginPCBean = (RespLoginPCBean) getSession().getAttribute(USERINFO);
        return respLoginPCBean;
    }
    @ExceptionHandler
    public ResultBo exception(Exception e){
        log.error("异常信息：",e);
        return ResultBo.build().errorHandle(e);
    }
}
