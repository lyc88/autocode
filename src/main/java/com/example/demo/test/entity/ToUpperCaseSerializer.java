package com.example.demo.test.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 序列化
 * @author lyc
 * @date 2019/6/3.
 */
public class ToUpperCaseSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(!StringUtils.isEmpty(s)){
            //拼接Http根地址与value值
            jsonGenerator.writeString(s.toUpperCase());
        }else {
            jsonGenerator.writeString(s);
        }
    }
}