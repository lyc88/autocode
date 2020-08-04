package com.example.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;
import com.example.demo.test.service.UserService;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

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
       // autoCode.autoCode("t_user_platform_info");
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
}
