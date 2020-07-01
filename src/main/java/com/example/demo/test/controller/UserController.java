package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.ExcelUtils;
import com.example.demo.bean.Result;
import com.google.common.collect.Lists;
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

import javax.servlet.http.HttpServletResponse;
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




}