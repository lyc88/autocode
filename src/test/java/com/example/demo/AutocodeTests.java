package com.example.demo;

import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;
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
    @Test
    public void contextLoads() throws IOException, TemplateException {
        autoCode.autoCode("t_user_system_info");
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
