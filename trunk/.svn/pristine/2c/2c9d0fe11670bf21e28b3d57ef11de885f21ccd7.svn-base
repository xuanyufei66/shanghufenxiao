package com.payease.scfordermis.configuration;

import com.payease.scfordermis.interceptor.AppLoginInterceptor;
import com.payease.scfordermis.interceptor.CrossDomainInterceptor;
import com.payease.scfordermis.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author : zhangwen
 * @Data : 2018/1/15
 * @Description :
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {


    @Bean
    AppLoginInterceptor appLoginInterceptor() {
        return new AppLoginInterceptor();
    }

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger3/").addResourceLocations("classpath:/swagger3/");


        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new CrossDomainInterceptor()).addPathPatterns("/**");
        //pc端登录拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
            .excludePathPatterns("/loginweb/login","/app/**","/swagger3/**","/v2/api-docs");
        //app端登录拦截器
        registry.addInterceptor(appLoginInterceptor()).addPathPatterns("/app/**")
            .excludePathPatterns("/app/customer/login/clientlogin","/app/driver/sendsms","/app/driver/login","/swagger3/**","/v2/api-docs");
        super.addInterceptors(registry);
    }
}
