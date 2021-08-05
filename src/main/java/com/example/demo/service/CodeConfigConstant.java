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
public class CodeConfigConstant {

    @Value("${code.childPath:src.main.java}")
    private String childPath;

    @Value("${code.childXmlPath:src.main.resources}")
    private String childXmlPath;

    @Value("${code.path:}")
    private String path;

    @Value("${code.entityPath:}")
    private String entityPath;

    @Value("${code.mapperPath:}")
    private String mapperPath;

    @Value("${code.servicePath:}")
    private String servicePath;

    @Value("${code.controllerPath:}")
    private String controllerPath;

    @Value("${code.write:false}")
    private Boolean write;

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
     * 设置包的路径 相对路径
     * @param packageMap
     */
    public void testPutPackage(Map packageMap){
        packageMap.put("entityAddPackage","com.example.demo.test.entity");
        packageMap.put("entityDeletePackage","com.example.demo.test.entity");
        packageMap.put("entityUpdatePackage","com.example.demo.test.entity");
        packageMap.put("entityQueryPackage","com.example.demo.test.entity");
        packageMap.put("entityPackage","com.example.demo.test.entity");
        packageMap.put("daoPackage","com.example.demo.test.mapper");

        packageMap.put("daoXmlPackage","mapper.xml");

        packageMap.put("servicePackage","com.example.demo.test.service");
        packageMap.put("serviceImplPackage","com.example.demo.test.service.impl");
        packageMap.put("controllerPackage","com.example.demo.test.controller");

        packageMap.put("commonPackage","com.example.demo.bean");
    }


    /**
     * 指定路径
     * @param packageMap
     */
    public void putPackage(Map packageMap){
        packageMap.put("entityAddPackage","com.vodsen.entity.param");
        packageMap.put("entityDeletePackage","com.vodsen.entity.param");
        packageMap.put("entityUpdatePackage","com.vodsen.entity.param");
        packageMap.put("entityQueryPackage","com.vodsen.entity.param");
        packageMap.put("entityPackage","com.vodsen.entity.po");

        packageMap.put("daoPackage","com.vodsen.mapper");
        packageMap.put("daoXmlPackage","mapper");

        packageMap.put("servicePackage","com.vodsen.service");
        packageMap.put("serviceImplPackage","com.vodsen.service.impl");

        packageMap.put("controllerPackage","com.vodsen.app.controller");
        //packageMap.put("controllerPackage","com.vodsen.web.controller");
        packageMap.put("controllerPackage","com.vodsen.miniprogram");

        packageMap.put("commonPackage","com.vodsen.common.bean");
        // 覆盖
        //testPutPackage(packageMap);
    }

}