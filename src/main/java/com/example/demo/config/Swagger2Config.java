package com.example.demo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lyc
 * @date 2019/6/13.
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

    @Value(value = "${swagger.enable:true}")
    private Boolean swaggerEnable;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //是否开启
                .enable(swaggerEnable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                //.paths(AppUtility.isProd() ? PathSelectors.none() : PathSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试swagger")
                .description("展示swagger界面")
                .termsOfServiceUrl("http://localhost:8089/swagger-ui.html")
                .contact(new Contact("lyc88", "http://localhost:8089/swagger-ui.html", "984006207@qq.com"))
                .version("1.0")
                .build();
    }
}