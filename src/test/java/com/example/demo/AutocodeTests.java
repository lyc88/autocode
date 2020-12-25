package com.example.demo;

import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;
import com.example.demo.test.entity.Book;
import com.example.demo.test.service.BookService;
import com.example.demo.utils.CharUtil;
import com.google.common.collect.Lists;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
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
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Author:   lyc
 * Date:     2020/7/1 16:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutocodeTests {

    /*@Autowired
    private MysqlAutoService mysqlAutoService;*/

    @Autowired
    private AutoCode autoCode;

    @Autowired
    private BookService bookService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void syncSend() {

        // 同步发送消息
        rocketMQTemplate.syncSend("DEMO_01", "hello");
    }

    /*public void asyncSend(Integer id, SendCallback callback) {
        // 创建 Demo01Message 消息
        Demo01Message message = new Demo01Message();
        message.setId(id);
        // 异步发送消息
        rocketMQTemplate.asyncSend(Demo01Message.TOPIC, message, callback);
    }

    public void onewaySend(Integer id) {
        // 创建 Demo01Message 消息
        Demo01Message message = new Demo01Message();
        message.setId(id);
        // oneway 发送消息
        rocketMQTemplate.sendOneWay(Demo01Message.TOPIC, message);
    }
*/
    @Test
    public void contextLoads() throws IOException, TemplateException {
        autoCode.autoCode("ant_area");
    }

    @Test
    public void testFiles(){
        File[] roots = File.listRoots();
        //File file = new File("G:\\");
        Arrays.stream(roots).forEach(e->list(e));
        //list(file);
        System.out.println(count);
        bookService.saveBatch(books);
    }

    public static int count = 0;
    List<Book> books = Lists.newArrayList();
    public List<String> list(File file){
        if(file.isDirectory()){
            String[] list = file.list();
            if(list != null && list.length>0)
            Arrays.stream(list).filter(e->!e.startsWith("Program Files (x86)")  && !e.startsWith("Program files") && !e.startsWith("Jisu"))
                    .forEach(e->list(new File(file,e)));
        }else if(file.isFile() &&  CharUtil.isChinese(file.getName()) && (file.getName().toLowerCase().endsWith("pdf") || file.getName().toLowerCase().equals("doc") || file.getName().toLowerCase().endsWith("docx") ||  file.getName().toLowerCase().endsWith(".xlsx")) ) {
            Book book = new Book();
            String name = file.getName();
            book.setName(name);
            book.setPath(file.getAbsolutePath());
            book.setImg("");
            book.setType(name.substring(name.lastIndexOf(".")));
            boolean b = file.getTotalSpace()>1024L;
            if(b){
                book.setSize((int)(file.length()/1024L));
            }else {
                book.setSize(0);
            }

            books.add(book);

            //System.out.println(file.getAbsolutePath());
            count++;
        }

        return null;
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
