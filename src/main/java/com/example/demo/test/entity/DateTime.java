package com.example.demo.test.entity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lyc on 2019/5/31.
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeConstraintValidator.class)
public @interface DateTime {
    boolean required() default true;

    String message() default "时间格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
