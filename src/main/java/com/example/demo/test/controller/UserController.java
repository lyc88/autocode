package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.annotation.CacheKey;
import com.example.demo.annotation.ParameterCacheKey;
import com.example.demo.enums.CacheEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
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
import java.util.List;
/**
* 
* @author lyc
* @date 2021-03-30 16:43:10
*/
@Api(value = "",tags={"操作接口"})
@RestController
public class UserController{

    @Autowired
    private UserService userService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("user/page")
    public CommonResult<User> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = userService.page(page);
        List<User>  userList = result.getRecords();
        return  CommonResultResponse.ok(userList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("user/list")
    public CommonResult<User> list(){
        List<User> userList = userService.list(new QueryWrapper<User>());
        return  CommonResultResponse.ok(userList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("user/delete")
    @CacheKey(cacheEvent = CacheEvent.DELETE)
    public CommonResult<Boolean> delete(@ParameterCacheKey(fieldName = "id") User user){
        Boolean success = userService.removeById(user.getId());
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("user/findById")
    @CacheKey
    public CommonResult<User> findById(@ParameterCacheKey(fieldName = "id") Integer id, HttpServletResponse response, HttpServletRequest request, MultipartFile file){
        User user = userService.getById(id);
        return CommonResultResponse.ok(user);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("user/add")
     public CommonResult<Boolean> add(User user){
        Boolean success = userService.save(user);
        return CommonResultResponse.ok(success);
     }
}