package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * @Author lyc
 * @Date 2021/1/19 14:01
 */
@Configuration
public class ConverterConfigBeans {

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private StringConverter stringConverter;

    //添加字符串参数去左右空白转换器
    @PostConstruct
    public void addConverter() {

        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer != null && initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(stringConverter);
        }

    }

}
