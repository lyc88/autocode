package com.example.demo.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyc
 * @date 2019/10/28.
 */
@Component
@Data
public class Constant {

    @Value("${childPath:src.main.java}")
    private String childPath;

    @Value("${code.path}")
    private String path;


    @Value("${author:lyc}")
    private String author;
    /**
     * 是否开启  swagger2
     */
    @Value(value = "${swagger.enable:false}")
    private Boolean swaggerEnable;


    //类型转换
    public static Map<String,String> map = new HashMap();

    static {
        map.put("tinyint","Integer");
        map.put("smallint","Integer");
        map.put("mediumint","Integer");
        map.put("int","Integer");
        map.put("integer","Integer");
        map.put("bigint","Long");
        map.put("float","Float");
        map.put("double","Double");
        map.put("decimal","BigDecimal");
        map.put("bit","Boolean");
        map.put("char","String");
        map.put("varchar","String");
        map.put("tinytext","String");
        map.put("text","String");
        map.put("mediumtext","String");
        map.put("longtext","String");
        map.put("date","Date");
        map.put("datetime","Date");
        map.put("timestamp","Date");
    }


    /**
     * 设置包的路径
     * @param packageMap
     */
    public void putPackage(Map packageMap){
        packageMap.put("entityAddPackage","com.example.demo.test.entity");
        packageMap.put("entityDeletePackage","com.example.demo.test.entity");
        packageMap.put("entityUpdatePackage","com.example.demo.test.entity");
        packageMap.put("entityQueryPackage","com.example.demo.test.entity");
        packageMap.put("entityPackage","com.example.demo.test.entity");
        packageMap.put("daoPackage","com.example.demo.test.mapper");

        packageMap.put("servicePackage","com.example.demo.test.service");
        packageMap.put("serviceImplPackage","com.example.demo.test.service.impl");
        packageMap.put("controllerPackage","com.example.demo.test.controller");

        packageMap.put("commonPackage","com.example.demo.bean");
    }

}