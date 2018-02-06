package com.payease.scfordermis.controller.app.driver;

import com.payease.scfordermis.bo.responseBo.app.driver.RespAppDriverLoginBean;
import com.payease.scfordermis.service.AppDriverLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangzhili on 2018/1/10.
 */

public class AppDriverBaseController {


    /**
     * 获取登录信息
     *
     * @param appDriverLoginService
     * @param token
     * @return
     * @throws Exception
     */
    protected RespAppDriverLoginBean getDriverUserInfo(AppDriverLoginService
                                                           appDriverLoginService, String token)
        throws Exception {
        return appDriverLoginService.getUserInRedis(token);
    }


}
