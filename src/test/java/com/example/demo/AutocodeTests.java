package com.example.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;
import com.example.demo.test.service.UserService;
import com.google.common.collect.Lists;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

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

        autoCode.autoCode("ums_remind_setting_content");
       /* Date date = DateUtil.parse("2021-04-19", "yyyy-MM-dd");
        System.out.println("before"+date.before(new Date()));

        System.out.println("after"+date.after(new Date()));

        Date dateTime = DateUtil.offsetDay(new Date(), -3);

        System.out.println(DateUtil.format(dateTime,"yyyy-MM-dd"));*/

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

       /* String daystr = "2010-09-10";
        String daystr1 = "2010-9-10";
        String daystr2 = "2010/09/10";
        String daystr3 = "2010/9/10";
        String daystr4 = "2010/9/1";
        Date parse = DateUtil.parse(daystr1);
        DateTime parse1 = DateUtil.parse(daystr2);
        String s = DateUtil.parse(daystr3).toString();
        String s1 = DateUtil.parse(daystr4).toString();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(parse1.toString());
        int ageOfNow = DateUtil.ageOfNow(parse);

        System.out.println(ageOfNow);*/

    }

    @Test
    public void testExcel() throws IOException {
        List<String> readLines = FileUtils.readLines(new File("D:\\ccode\\server-genesis\\genesis-user\\src\\main\\resources\\i18n\\messages_zh_CN.properties"));
        ExcelWriter writer = ExcelUtil.getWriter("d:/app国际化表格.xlsx");
        List<Map> rows = Lists.newArrayList();


        readLines.forEach(e->{
            if(StringUtils.isNotBlank(e)){
                Map<String, Object> row2 = new LinkedHashMap<>();
                String[] split = e.split("=");
                row2.put("字典值", split[0]);
                row2.put("中文", UnicodeUtil.toString(split[1]));
                row2.put("英文","");
                rows.add(row2);
            }

        });


        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
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
