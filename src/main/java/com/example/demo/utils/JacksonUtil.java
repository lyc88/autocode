package com.example.demo.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lyc
 * @date 2019/5/13.
 */
public class JacksonUtil {

    //配置ObjectMapper对象
    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    /**
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
     *      转换为普通JavaBean：readValue(json,Student.class)
     *      转换为List:readValue(json,List.class).readValue(json,List.class)返回其实是List<Map>类型，第二个参数不能是List<Student>.class，所以不能直接转换。
     *      转换为特定类型的List，比如List<Student>，把readValue()的第二个参数传递为Student[].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List。
     *      转换为Map：readValue(json,Map.class)
     *      我们使用泛型，得到的也是泛型
     *
     * @param content   要转换的JavaBean类型
     * @param valueType  原始json字符串数据
     * @return           JavaBean对象
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            //字符串转Json对象
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 把JavaBean转换为json字符串
     *      普通对象转换：toJson(Student)
     *      List转换：    toJson(List)
     *      Map转换:      toJson(Map)
     * 我们发现不管什么类型，都可以直接传入这个方法
     *
     * @param object  JavaBean对象
     * @return        json字符串
     */
    public static String toJSon(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            //Json对象转为String字符串
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}