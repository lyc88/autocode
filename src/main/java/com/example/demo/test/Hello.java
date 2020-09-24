package com.example.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lyc
 * @date 2020/9/15 19:04
 * @describe
 */

//@Component
//@PropertySource("classpath:hello-${spring.profiles.active}.properties")
public class Hello {

    //@Value("${aaa}")
    private String aa;

    public String getAa() {
        return aa;
    }
}
