package com.example.demo.test.controller;
import java.math.BigDecimal;
import java.util.Date;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepoove.poi.XWPFTemplate;
import com.example.demo.bean.ExcelUtils;
import com.example.demo.bean.Result;
import com.example.demo.test.Hello;
import com.example.demo.test.entity.TestUser;
import com.google.common.collect.Lists;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* 
* @author lyc
* @date 2020-07-01 17:19:03
*/
@Api(value = "",tags={"操作接口"})
@RestController
public class UserController{

    @Autowired
    private UserService userService;


    @RequestMapping("user/export")
    public void exportUser(HttpServletResponse httpServletResponse){
        List<User> list = userService.list();
        List<Map> rows = Lists.newArrayList();
        list.forEach(e->{
            Map row = new HashMap();
            row.put("姓名",e.getName());
            row.put("年龄",e.getAge());
            rows.add(row);
        });
        ExcelUtils.exportExcel(httpServletResponse,"用户列表",rows);
    }


    @RequestMapping("user/import")
    public Result importUser(MultipartFile file){
        List<Map<String, Object>> mapList = ExcelUtils.importExcel(file);
        List<User> userList =  Lists.newArrayList();
        mapList.forEach(e->{
            String name = String.valueOf(e.get("姓名"));
            Integer age = Integer.parseInt(String.valueOf(e.get("年龄")));
            User user = new User();
            user.setId(1);
            user.setAge(age);
            user.setName(name);
            userList.add(user);
        });
        userService.saveBatch(userList);
        return Result.ok();
    }


    @RequestMapping("user/exportTpl")
    public void exportUserTpl(@RequestBody User user,HttpServletResponse httpServletResponse){
        List<String> hearder = Lists.newArrayList();
        hearder.add("用户名");
        hearder.add("年级");
        ExcelUtils.exportExcelTpl(httpServletResponse,"用户模板",hearder);
    }


    @RequestMapping("user/list")
    public void list(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String attachName = new String(("测试").getBytes(), "ISO-8859-1");
        response.setHeader("Content-disposition","attachment;filename="+attachName+".docx");
        InputStream inputStream = new ClassPathResource("templates/test01.docx").getInputStream();
        XWPFTemplate template = XWPFTemplate.compile(inputStream);
        Map map = new HashMap();
        map.put("title", "Hi, poi-tl Word模板引擎");
        template.render(map);
        OutputStream out = response.getOutputStream();

        template.write(out);
        template.close();
        out.flush();
        out.close();
        //return Result.ok(userService.list());
    }


    @RequestMapping("user/save")
    public Result save(@Validated @RequestBody User user){
        return Result.ok(userService.save(user));
    }

   /* @Autowired
    private Hello hello;
    @RequestMapping("user/update.html")
    public Result update(User user){
        return Result.ok(hello.getAa());
    }*/



    @RequestMapping("user/update.html")
    public Result getUserList(String name, HttpServletRequest httpServletRequest){
        TestUser testUser = new TestUser();
        testUser.setBigDecimal(new BigDecimal("0"));
        testUser.setDate(new Date());

        System.out.println(httpServletRequest.getParameter("name"));
        return Result.ok(testUser);
    }
}