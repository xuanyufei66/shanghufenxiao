package com.payease.scfordermis.service.impl;

import com.payease.scfordermis.bo.responseBo.RespClientInfo;
import com.payease.scfordermis.entity.TConsumerInfoEntity;
import com.payease.scfordermis.service.IAppMyInfoService;
import com.payease.scfordermis.service.LoginClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * @Author : zhangwen
 * @Data : 2018/1/22
 * @Description :
 */
@Service
public class AppMyInfoServiceImpl implements IAppMyInfoService {


    private static final Logger log = LoggerFactory.getLogger(AppMyInfoServiceImpl.class);
    @Autowired
    EntityManager em;
    @Autowired
    LoginClientService loginClientService;

    /**
     * @param token
     * @Author zhangwen
     * @MethodName getConsumerDetail
     * @Params String token
     * @Return RespClientInfo
     * @Date 2018/1/22 下午2:49
     * @Desp 获取客户详细信息 app端-我的 使用
     */
    @Override
    public RespClientInfo getConsumerDetail(String token) throws Exception{

        RespClientInfo result = new RespClientInfo();

        try {
            //1.根据token从redis中获取客户id
            TConsumerInfoEntity entity = this.loginClientService.getUserInRedis(token);
            long consumerId = entity.getfId();
            //2.封装查询sql
            String querySql = querySql(consumerId);
            //3。封装查询结果
            Query query =  em.createNativeQuery(querySql);
            List objecArraytList = query.getResultList();
            for(int i=0;i<objecArraytList.size();i++) {
                Object[] obj = (Object[]) objecArraytList.get(i);
                result.setConsumerName(obj[0].toString());
                result.setServerPhone(obj[1].toString());
                result.setAreaName(obj[2].toString());
                result.setLevelName(obj[3].toString());
                result.setIndentNo(obj[4].toString());
                result.setContact(obj[5].toString());
                result.setPhone(obj[6].toString());
                return result;
            }
        } catch (Exception e) {
            log.error("getConsumerDetail",e);
            e.printStackTrace();
            throw e;
        }
        return null;

    }


    /**
     * @Author zhangwen
     * @MethodName querySql
     * @Params [consumerId]
     * @Return java.lang.String
     * @Date 2018/1/22 下午3:46
     * @Desp 拼接查询使用的sql
     */
    private String querySql(long consumerId ){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" SELECT t1.f_name AS consumerName ,t2.f_service_number AS serverPhone ,CONCAT_WS('-',t3.f_name,t4.f_name) AS areaName ,t5.f_name AS levelName ,t1.f_indent_no as indentNo,t1.f_contact as contact, t1.f_phone as phone");
        stringBuffer.append(" FROM t_consumer_info t1");
        stringBuffer.append(" LEFT JOIN t_company_info t2 ON t1.f_company_id = t2.f_id");
        stringBuffer.append(" LEFT JOIN t_area_info t3 ON t1.f_area_id_one = t3.f_id");
        stringBuffer.append(" LEFT JOIN t_area_info t4 ON t1.f_area_id_two = t4.f_id");
        stringBuffer.append(" LEFT JOIN t_consumer_level t5 ON t1.f_level_id = t5.f_id");
        stringBuffer.append(" where t1.f_id = ");
        stringBuffer.append(consumerId);
        return  stringBuffer.toString();
    }
}
