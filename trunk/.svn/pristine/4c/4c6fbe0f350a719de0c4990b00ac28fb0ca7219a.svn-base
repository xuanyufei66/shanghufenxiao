package com.payease.scfordermis.controller;

import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.requestBo.UserBean;
import com.payease.scfordermis.bo.responseBo.PageResponseCommBean;
import com.payease.scfordermis.service.IUserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by lch on 2018/1/4.
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"用户操作类"})
public class UsrController {
    private static final Logger log = LoggerFactory.getLogger(UsrController.class);

    @Autowired
    private IUserService userService;



    @GetMapping(value = "index")
    @ApiOperation(value = "获取用户详情",response = UserBean.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "abc",value = "时间类型",paramType = "query")
    })
    public ResultBo index(HttpSession session, int a, Date abc) {
        ResultBo result = ResultBo.build();
        return result;
    }


    @GetMapping(value = "test")
    @ApiOperation(value = "测试分页",response = PageResponseCommBean.class)
    public ResultBo test(HttpSession session) {
        ResultBo result = ResultBo.build();
//        PageResponseCommBean bean = new PageResponseCommBean();
//        bean.setContent(this.userService.findAllEm());

        result.setResultBody(this.userService.testPage());
        return result;
    }

}
