package com.example.demo.annotation;


import com.example.demo.enums.CacheEvent;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface CacheKey {

    /**
     * 缓存键名称注解，默认值为类名称
     *
     * @return
     */
    String key() default "cacheKey:";

    /**
     * 缓存过期时间，默认3分钟
     *
     * @return
     */
    int expireTime() default 3*60;

    /**
     * 缓存过期时间单位，默认为秒
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 缓存事件 默认查询
     * @return
     */
    CacheEvent cacheEvent() default CacheEvent.QUERY;

}
