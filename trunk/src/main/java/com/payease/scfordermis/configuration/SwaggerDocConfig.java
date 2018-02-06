package com.payease.scfordermis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhangzhili on 2018/1/8.
 */
@Configuration
@EnableSwagger2
public class SwaggerDocConfig {

    @Bean
    public Docket customDocket() {
        //
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("易支付天津团队", "暂无", "暂无");
        return new ApiInfo("分销系统接口文档",//大标题 title
            "易支付天津团队内部使用",//小标题
            "0.0.1",//版本
            "五",//termsOfServiceUrl
            contact,//作者
            "无",//链接显示文字
            "无"//网站链接
        );
    }
}
