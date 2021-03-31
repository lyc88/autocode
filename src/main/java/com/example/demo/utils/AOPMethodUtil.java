package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * AOP切面获取方法实体类参数值
 */
@Slf4j
public class AOPMethodUtil {
    /**
     * 基础数据类型
     */
    private static List<String> types =
            Arrays.asList("java.lang.Integer", "java.lang.Double",
                    "java.lang.Float", "java.lang.Long", "java.lang.Short",
                    "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
                    "java.lang.String", "int", "double", "long", "short", "byte",
                    "boolean", "char", "float");

    /**
     * 获取参数值
     *
     * @param joinPoint
     * @param fieldName 参数字段名
     * @return
     */
    public static Object getParamValue(JoinPoint joinPoint, String fieldName) {
        Object value = "";
        //获取所有的参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            // 获取对象类型
            String typeName = arg.getClass().getTypeName();
            //1 判断是否是基础类型
            if (types.contains(typeName)) {
                value = arg;
            } else {
                //2 通过反射获取实体类属性
                value = getFieldsValue(arg, fieldName);
            }
            break;
        }

        return value;
    }

    /**
     * 解析实体类，获取实体类中的指定属性値
     *
     * @param object    参数实体对象
     * @param fieldName 字段
     * @return
     */
    public static Object getFieldsValue(Object object, String fieldName) {
        //通过反射获取所有的字段，getFileds()获取public的修饰的字段
        //getDeclaredFields获取private protected public修饰的字段
        Field[] fields = object.getClass().getDeclaredFields();
        String typeName = object.getClass().getTypeName();
        if (types.contains(typeName)) {
            return object;
        }
        Object value = "";
        for (Field field : fields) {
            //在反射时能访问私有变量
            field.setAccessible(true);
            try {
                //如果实体类里面继续包含实体类，就没法获取。
                //我们可以通递归的方式去处理实体类包含实体类的问题。
                if (types.contains(field.getType().getName())) {
                    if (field.getName().equals(fieldName)) {
                        value = field.get(object) == null ? "" : field.get(object).toString();
                        return value;
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.error("error {}",e);
            }
        }
        return value;
    }

    /**
     * 解析实体类，获取实体类中的属性
     *
     * @param object
     * @return
     */
    public static Object getFieldsValue(Object object) {
        //通过反射获取所有的字段，getFileds()获取public的修饰的字段
        //getDeclaredFields获取private protected public修饰的字段
        Field[] fields = object.getClass().getDeclaredFields();
        String typeName = object.getClass().getTypeName();
        if (types.contains(typeName)) {
            return object;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field f : fields) {
            //在反射时能访问私有变量
            f.setAccessible(true);
            try {
                //这边会有问题，如果实体类里面继续包含实体类，这边就没法获取。
                //其实，我们可以通递归的方式去处理实体类包含实体类的问题。
                if (types.contains(f.getType().getName())) {
                    sb.append(f.getName()).append(" : ").append(f.get(object)).append(", ");
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.error("error {}",e);
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
