package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author lyc
 * @date 2020/10/21 11:48
 * @describe
 * link https://blog.csdn.net/qq_38132283/article/details/89339817
 *
 * https://www.jianshu.com/p/2af1104a1b5d
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(new JacksonHttpMessageConverter());
    }

}
