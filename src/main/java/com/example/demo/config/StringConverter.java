package com.example.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Author lyc
 * @Date 2021/1/19 14:01
 */
@Component
public class StringConverter implements Converter<String, String> {
    @Override
    public String convert(String s) {
        return StringUtils.trim(s);
    }
}
