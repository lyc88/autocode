/*
package com.example.demo.config;


import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;


public class PrefixUrlMapping extends RequestMappingHandlerMapping {

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    static {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        pathMatcher.setCachePatterns(true);
        pathMatcher.setCaseSensitive(true);
        pathMatcher.setTrimTokens(true);
        pathMatcher.setPathSeparator(".");
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
        if (requestMappingInfo != null) {
            String packageName = handlerType.getPackage().getName();
            if (isMatching(packageName)) {
                ApiVersion t = handlerType.getAnnotation(ApiVersion.class);
                ApiVersion m = method.getAnnotation(ApiVersion.class);
                if (m != null && t != null) {
                    return RequestMappingInfo.paths(m.value().name().toLowerCase()+ "/" +packageName.split("\\.")[3]).build().combine(requestMappingInfo);
                } else if (m != null || t != null) {
                    return RequestMappingInfo.paths((t != null ? t.value().name().toLowerCase() :
                            m.value().name().toLowerCase()) + "/" + packageName.split("\\.")[3]).build().combine(requestMappingInfo);
                } else {
                    return RequestMappingInfo.paths(API.V1+"/"+packageName.split("\\.")[3]).build().combine(requestMappingInfo);
                }
            }
        }
        return requestMappingInfo;
    }


    private boolean isMatching(String packageName) {
        return (pathMatcher.match("com..**.controller", packageName) &&
                !packageName.equals("com.framework.boot.base.exception.controller")) ||
                pathMatcher.match("com.**.api", packageName);
    }

}*/
