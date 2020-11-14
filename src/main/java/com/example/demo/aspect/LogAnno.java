package com.example.demo.aspect;

import java.lang.annotation.*;

/**
 * @author lyc
 * @date 2020/11/14 9:23
 * @describe
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnno {

    String typeExpression() default "";
}
