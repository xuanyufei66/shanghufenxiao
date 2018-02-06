package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.dao.ConsumerInfoDao;
import com.payease.scfordermis.dao.TransportOrderDao;
import com.payease.scfordermis.service.AppDriverSendLoginCodeService;
import com.payease.scfordermis.utils.RandomUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 司机端（APP）-司机登录-发送短信验证码
 * @Created By liuxiaoming
 * @CreateTime 2018/1/22 上午11:32
 **/
@Service
public class AppDriverSendLoginCodeServiceImpl implements AppDriverSendLoginCodeService{

    private static final Logger log = LoggerFactory.getLogger(AppDriverSendLoginCodeServiceImpl.class);

    @Autowired
    StringRedisTemplate stringRedis;
    @Autowired
    private TransportOrderDao transportOrderDao;
    @Autowired
    private ConsumerInfoDao consumerInfoDao;

    /**
     * 发送短信验证码
     "phone", value = "手机号", paramType = "query", required = true)
     "smsType", value = "发送场景 dirverLogin:司机端登录 misLogin:客户端登录", paramType = "query",
     * @param phone
     * @param smsType
     * @return
     */
    @Override
    public ResultBo sendLoginCode(String phone, String smsType) throws Exception{
        ResultBo result = ResultBo.build();
        try {
            if (StringUtils.isBlank(phone)) {
                return result.fail();
            }
            String key = "-login-" + phone;
            //短信验证码（暂为四位随机数）
            String code = RandomUtil.RandomNumber(4);
            switch (smsType) {
                case "dirverLogin":
                    //司机端登录
                    //校验
                    //  表：  t_transport_order
                    //  字段：f_driver_phone 司机手机号  f_status ForGoods-待提货
                    if(transportOrderDao.countByFDriverPhoneAndFStatus(phone,"ForGoods") == 0){
                        //该手机号未查到待提货订单
                        log.error("AppDriverSendLoginCodeService - - sendLoginCode :"+Status.MSGPHONEISNOTFORGOODS.getMessage());
                        return result.setCodeId(Status.MSGPHONEISNOTFORGOODS);
                    }
                    stringRedis.opsForValue().set("driver" + key, code, 5, TimeUnit.MINUTES);
                    break;
                case "misLogin":
                    //客户端登录
                    //校验
                    //  表：   t_consumer_info
                    //  字段：  f_indent_status:   f_is_delete
                    if(consumerInfoDao.countByFPhoneAndFIndentStatusAndFIsDelete(phone,"open","no") == 0){
                        //该手机号状态异常
                        log.error("AppDriverSendLoginCodeService - - sendLoginCode :"+Status.MSGPHONESTATUSERROR.getMessage());
                        return result.setCodeId(Status.MSGPHONESTATUSERROR);
                    }
                    stringRedis.opsForValue().set("mis" + key, code, 5, TimeUnit.MINUTES);
                    break;
                default:
                    //发送场景类型不正确
                    log.error("AppDriverSendLoginCodeService - - sendLoginCode :"+Status.MSGUSECASE.getMessage());
                    return result.setCodeId(Status.MSGUSECASE);
            }
            Map<String, String> map = new HashMap();
            map.put("code", code);
            result.setResultBody(map);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.fail();
            log.error("AppDriverSendLoginCodeService - - sendLoginCode :",e);
            throw e;
        }
    }
}
