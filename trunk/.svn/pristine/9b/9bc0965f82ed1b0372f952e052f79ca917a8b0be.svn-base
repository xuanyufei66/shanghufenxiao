package com.payease.scfordermis.service.impl;

import com.alibaba.fastjson.JSON;
import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.ResultBo;

import com.payease.scfordermis.bo.responseBo.app.driver.RespAppDriverLoginBean;
import com.payease.scfordermis.dao.TransportOrderDao;
import com.payease.scfordermis.entity.TTransportOrderEntity;
import com.payease.scfordermis.service.AppDriverLoginService;
import com.payease.scfordermis.utils.RandomUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhoushijie on 2018/1/23.
 */
@Service
public class AppDriverLoginServiceImpl implements AppDriverLoginService {
    private static final Logger log = LoggerFactory.getLogger(AppDriverLoginServiceImpl.class);
    @Autowired
    StringRedisTemplate redis;//获取Redis
    @Autowired
    TransportOrderDao transportOrderDao;


    /**
     * 司机端登录
     */
    @Override
    public ResultBo login(String username, String code) throws Exception {
        ResultBo result = ResultBo.build();
        try {
            //判断(手机号)
            if (StringUtils.isBlank(username) || StringUtils.isBlank(code)){
                return result.queryError();
            }
            //短信验证码(入参)

//            String msgCode = redis.opsForValue().get("driver-login-"+username);//获取短信验证码(redis)
//            if (StringUtils.isBlank(msgCode)){
//                return result.setCodeId(Status.DRIMSGCODE);//验证码获取失败
//            }
            //验证短信验证码 入参 是否等于 Redis
//            if(!code.equals(msgCode)){return result.setCodeId(Status.DRIMSGCODEERR);}
            //根据手机号来查找
            List<TTransportOrderEntity> list = transportOrderDao.findByFDriverPhone(username);
            //查找数据库中登录账号
            if (list == null || list.size()==0){return result.setCodeId(Status.DIRLOGINISNULL);}
            TTransportOrderEntity one = list.get(0);
            //判断订单状态 只有 ForLoading-待装车；ForGoods-待提货；HasCompleted-已完成
            //通过 查找订单状态
            if ("ForGoods".equals(one.getfStatus())){

                //生成token
                String token = createToken(username);
                //向Redis中保存token
                this.saveUserToken(token,one);
                //获取出参
                result = getParameter(token);
            }else {
                return result.setCodeId(Status.ORDERSTATUSERR);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("DriverloginError",e);
            result.setCodeId(Status.DRIVERLOGERROR);
            throw e;
        }
    }


    /**
     * 创建token
     */
    private String createToken(String username) throws  Exception{
        String tokenText = "driver-login-"+username+ RandomUtil.RandomNumber(6);
        return DigestUtils.md5Hex(tokenText).toUpperCase();
    }

    //向Redis中保存token
    private void saveUserToken(String token,TTransportOrderEntity one) throws Exception{
            //向redis中存 user    login-手机号-随机数
            RespAppDriverLoginBean resp = new RespAppDriverLoginBean();
            //出参   获取运单id
            resp.setId(one.getId());
            //获取公司id
            resp.setfCompanyId(one.getfCompanyId());
            //车牌号
            resp.setfCarNum(one.getfCarNum());
            //运输单号
            resp.setfTransportNum(one.getfTransportNum());

            resp.setToken(token);
            redis.opsForValue().set(token,JSON.toJSONString(resp),7,TimeUnit.DAYS);

    }


    /**
     * 获取出参
     */
    private ResultBo getParameter(String token)throws Exception{
        ResultBo result = ResultBo.build();
        result.setResultBody(token);
        return result;

    }

    //==================================================================================

    /**
     * 自动登录
     */
    @Override
    public ResultBo autoLogin(String token) throws Exception {
        ResultBo result =ResultBo.build();
        try{
            //从redis中获取token
            if(StringUtils.isBlank(token)){return result.queryError();}
            String info = redis.opsForValue().get(token);
            if(StringUtils.isBlank(info)){return result.timeOut();}
            RespAppDriverLoginBean redisInfo = JSON.parseObject(info, RespAppDriverLoginBean.class);
            //判断数据中的token是否为null
            //1.判断token是否存在
            if(redisInfo != null &&  redisInfo.getId() != null){
                //获取redisInfo中的运单id查找对象 对象是空则token不存在RespAppDriverLoginBean
                TTransportOrderEntity one = transportOrderDao.findOne(redisInfo.getId());
                if(one == null){return result.setCodeId(Status.TOKENISNULL);}
                String newTokenVal = this.createToken(one.getfDriverPhone());
                //更新redis
                this.updateRedisToken(one,newTokenVal,token);
                //出参
                result = getParameter(newTokenVal);
            }else {
                //2.token失效 返回异常
                result.timeOut();
            }
            return result;
        }catch (Exception e){
             e.printStackTrace();
            log.error("autoLoginError",e);
            result.fail();
            throw e;
        }
    }


    /**
     * 更新token有效期
     */
    private void updateRedisToken(TTransportOrderEntity one,String newTokenVal,String token)throws Exception{


        String info =String.valueOf(redis.opsForValue().get(token)) ;
            if(StringUtils.isNotBlank(info)){
                //删除token与user的redis 然后插入新的token与user的redis
                redis.delete(token);
            }
        //删除token与user的redis 然后插入新的token与user的redis
        this.saveUserToken(newTokenVal,one);


    }
    //=========================================================================================


    //根据token获取redis中的用户信息
    @Override
    public RespAppDriverLoginBean getUserInRedis(String token) throws Exception {
        RespAppDriverLoginBean bo = null;
        try{
            String userVal =String.valueOf(redis.opsForValue().get(token)) ;
            if(StringUtils.isBlank(userVal)){return null;}
            bo = JSON.parseObject(userVal,RespAppDriverLoginBean.class);
        }catch (Exception e){
            e.printStackTrace();
            log.error("getUserInRedis",e);
            throw e;
        }finally {
            return bo;
        }

    }
    //登出
    @Override
    public ResultBo logout(String token) throws Exception {
        ResultBo result = ResultBo.build();
        try{
            redis.delete(token);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            log.error("logout",e);
            result.setCodeId(Status.DIRLOGOUTERR);
            throw e;
        }
    }
}
