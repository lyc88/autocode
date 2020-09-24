package com.example.demo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;
import com.example.demo.test.entity.TestUser;
import com.example.demo.test.service.UserService;
import freemarker.template.TemplateException;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author:   lyc
 * Date:     2020/7/1 16:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutocodeTests {

    @Autowired
    private MysqlAutoService mysqlAutoService;
    @Autowired
    private AutoCode autoCode;
    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() throws Exception {
        //autoCode.autoCode("salesman");
        // userService.saveU(null);
       /* DateTime endTime = DateUtil.endOfDay(new Date());
        DateTime startTime = DateUtil.beginOfDay(new Date());
        System.out.println(" time "+endTime.getTime());
        System.out.println(" time "+endTime.getTime()/1000L);

        System.out.println("--"+endTime.toCalendar().getTimeInMillis());
        String end = DateUtil.format(new Date(endTime.getTime()), "yyyy-MM-dd HH:mm:ss");
        String start = DateUtil.format(new Date(startTime.getTime()), "yyyy-MM-dd HH:mm:ss");
        System.out.println(end);
        System.out.println(start);

        DateTime dateTime = DateUtil.beginOfDay(new Date(1595210051*1000));
        String d = DateUtil.format(new Date(dateTime.getTime()), "yyyy-MM-dd HH:mm:ss");
        System.out.println(d);
        System.out.println((System.currentTimeMillis()+"").length());*/
        TestUser testUser = new TestUser();

        testUser.setBigDecimal(new BigDecimal("12"));

        String jsonString = JSON.toJSONString(testUser);
        TestUser testUser1 = JSON.parseObject(jsonString, TestUser.class);

        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonString);

    }

    @Test
    public void test(){
        Reflections reflections = new Reflections("com.example.demo");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(RestController.class);
        annotated.forEach(e->{
            System.out.println(e.getName());
            Method[] methods = e.getMethods();
            for (Method method:methods){
                //System.out.println("method:" +method.getName());
                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                if(annotation != null){
                    String[] value = annotation.value();
                    if(value != null && value.length>=1)
                        System.out.println("value:" +value[0]);
                }
            }
        });
    }

    @Test
    public void testF() throws IOException {
        List<String> strings = FileUtils.readLines(new File("D:\\m-food.fincy.com.log"), "UTF-8");
        long start = System.currentTimeMillis();

        List<String> collect = strings.stream().map(e -> e.split(",")[1]).collect(Collectors.toList());
        Map<Object, List<String>> collect1 = collect.stream().collect(Collectors.groupingBy(e->e));
        List<Map> list = Lists.newArrayList();
        for (Map.Entry<Object,List<String>> entry:collect1.entrySet()){
            String key = entry.getKey()+"";
            int size = entry.getValue().size();
            HashMap<String,Object> hashMap = new HashMap();
            hashMap.put("ip",key);
            hashMap.put("count",size);
            list.add(hashMap);
        }
        list.sort((e1,e2)->{
            Integer count = Integer.valueOf(e1.get("count")+"");
            Integer count1 = Integer.valueOf(e2.get("count") + "");

            return count1-count;
        });

        System.out.println(list);
        //list.stream().map(e->e.get("count")).reduce(0,);
        List<String> ids = collect.stream().map(e -> e.split(":")[1]).distinct().collect(Collectors.toList());

        System.out.println("文件行数"+strings.size());
        System.out.println("ip数："+ids.size());
        //System.out.println(ids);


        long end = System.currentTimeMillis();

        System.out.println("耗时"+(end-start)/1000+"秒");
    }


    @Test
    public void testMap() throws IOException {
        TestUser testUser = new TestUser();
        testUser.setBigDecimal(new BigDecimal("123.12"));
        testUser.setDate(new Date());


        Map<String, Object> map = BeanUtil.beanToMap(testUser);
        Map<String, String> paramMap = Convert.toMap(String.class, String.class, map);


        System.out.println(paramMap);
    }
}
