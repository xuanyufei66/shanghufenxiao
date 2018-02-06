package com.payease.scfordermis.controller.app.customer;

import com.payease.scfordermis.entity.TConsumerInfoEntity;
import com.payease.scfordermis.service.LoginClientService;

/**
 * Created by zhangzhili on 2018/1/10.
 */

public class AppCustomerBaseController {

    protected TConsumerInfoEntity getUserInfo(LoginClientService loginClientService, String
        token) throws Exception {
        return loginClientService.getUserInRedis(token);
    }
}



