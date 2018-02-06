package com.payease.scfordermis.interceptor;

import com.alibaba.fastjson.JSON;
import com.payease.scfordermis.bo.ResultBo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author : zhangwen
 * @Data : 2018/1/24
 * @Description :
 */
@Component
public class AppLoginInterceptor  implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate;//获取Redis

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o) throws Exception {
        ResultBo result = ResultBo.build();
        Map<String, String[]> properties = httpServletRequest.getParameterMap();//把请求参数封装到Map<String, String[]>中
        if(!properties.containsKey("token")){
            result.setCodeId(-4);
            result.setMessage("没有传入用户标识token");
            System.err.println("没有token");
            httpServletResponse.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        Iterator<Map.Entry<String, String[]>> iter = properties.entrySet().iterator();
        String token="";
        while (iter.hasNext()) {
            Map.Entry<String, String[]> entry = iter.next();
            String name = entry.getKey();
            String value = "";
            if("token".equals(name)){
                Object valueObj = entry.getValue();
                if (valueObj instanceof String[]){
                    String[] values = (String[]) valueObj;
                    for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
                        value = values[i] + ",";
                    }
                    token = value.substring(0, value.length() - 1);
                    System.err.println(token);
                }
            }
            if(StringUtils.isNotBlank(token)){
               if(!stringRedisTemplate.hasKey(token)){
                   httpServletResponse.getWriter().print(JSON.toJSONString(result.timeOut()));
                   return false;
               }
            }


        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {

    }
}
