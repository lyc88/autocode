package com.example.demo;

import com.example.demo.service.MysqlAutoService;
import com.example.demo.test.entity.Book;
import com.example.demo.test.service.BookService;
import com.example.demo.utils.CharUtil;
import com.google.common.collect.Lists;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
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

    @Autowired
    private MysqlAutoService mysqlAutoService;

    @Autowired
    private BookService bookService;

    @Test
    public void contextLoads() throws IOException, TemplateException {
        mysqlAutoService.autoCode("book");
    }

    @Test
    public void testFiles(){
        File[] roots = File.listRoots();
        //File file = new File("G:\\");
        Arrays.stream(roots).forEach(e->list(e));
        //list(file);
        System.out.println(count);
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
            book.setSize((int)file.getTotalSpace()/1024);
            books.add(book);

            //System.out.println(file.getAbsolutePath());
            count++;
        }
        bookService.saveBatch(books);
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
