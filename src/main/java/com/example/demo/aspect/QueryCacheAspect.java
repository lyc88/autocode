package com.example.demo.aspect;


import cn.hutool.crypto.digest.MD5;
import com.example.demo.annotation.CacheKey;
import com.example.demo.annotation.ParameterCacheKey;
import com.example.demo.enums.CacheEvent;
import com.example.demo.utils.AOPMethodUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.SynthesizingMethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import java.util.Objects;

/**
 * 查询缓存切面
 */
@Aspect
@Service
@Slf4j
public class QueryCacheAspect {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 定义拦截规则：拦截所有@QueryCache注解的方法。
     */
    @Pointcut("@annotation(com.example.demo.annotation.CacheKey)")
    public void queryCachePointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("queryCachePointcut()")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取被拦截的方法
        Method method = signature.getMethod();
        //获取方法注解
        CacheKey cacheKey = method.getAnnotation(CacheKey.class);

        CacheEvent cacheEvent = cacheKey.cacheEvent();
        String key = cacheKey.key();

        StringBuilder realKey = new StringBuilder(cacheKey.key());

        // 循环所有的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            MethodParameter methodParam = new SynthesizingMethodParameter(method, i);
            //获取参数注解
            Annotation[] parameterAnnotations = methodParam.getParameterAnnotations();
            // 循环参数上所有的注解
            for (Annotation paramAnn : parameterAnnotations) {
                if (paramAnn instanceof ParameterCacheKey) {
                    ParameterCacheKey parameterCacheKey = (ParameterCacheKey) paramAnn;
                    //取到ParameterCacheKey的标识参数的值
                    Object fieldValue = AOPMethodUtil.getParamValue(args[i], parameterCacheKey.fieldName());
                    realKey.append(":").append(parameterCacheKey.fieldName()).append(":").append(fieldValue);
                    break;
                }
            }
        }

        //获取不到key值，抛异常
        if (StringUtils.isBlank(realKey.toString())) throw new RuntimeException("****缓存key值不存在****");
        // 如果没有 ParameterCacheKey 注解 默认md5(类名+方法+参数)
        if ((Objects.equals(realKey.toString(), key))) {
            realKey.append(":").append(getKey(signature, joinPoint.getArgs()));
        }
        log.debug("获取到缓存key值 {} ", realKey);
        boolean hasKey = redisTemplate.hasKey(realKey.toString());
        if (hasKey) {
            // 根据对应操作
            if (Objects.equals(cacheEvent, CacheEvent.QUERY)) {
                // 缓存中获取到数据，直接返回。
                Object object = redisTemplate.opsForValue().get(realKey.toString());
                log.debug("缓存命中耗时：{}", (System.currentTimeMillis() - beginTime));
                return object;
            }
            if (Objects.equals(cacheEvent, CacheEvent.DELETE)) {
                // 缓存中获取到数据，直接返回。
                redisTemplate.delete(realKey.toString());
            }
        }

        Object object = joinPoint.proceed();
        //设置缓存
        if (Objects.equals(cacheEvent, CacheEvent.QUERY)) {
            redisTemplate.opsForValue().set(realKey.toString(), object, cacheKey.expireTime(),
                    cacheKey.timeUnit());
        }

        log.debug("结束耗时：{}", (System.currentTimeMillis() - beginTime));
        return object;
    }

    /**
     * 默认md5(类名+方法+参数)
     *
     * @param methodSignature
     * @param args
     * @return
     */
    private String getKey(MethodSignature methodSignature, Object[] args) {
        StringBuilder key = new StringBuilder(methodSignature.getDeclaringTypeName());
        key.append(methodSignature.getMethod().getName());
        Object[] paramValues = args;
        String[] paramNames = (methodSignature).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            key.append(paramValues[i]);
        }
        return MD5.create().digestHex(key.toString());
    }
}