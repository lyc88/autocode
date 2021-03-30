package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 参数注解,用于指定要获取的参数字段。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface ParameterCacheKey {
    /**
     * 参数字段
     *
     * @return
     */
    String fieldName() default "";
}
