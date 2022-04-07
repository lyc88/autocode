package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import com.example.demo.test.entity.SysUser;
import com.example.demo.test.entity.SysUserAddParam;
import com.example.demo.test.entity.SysUserDeleteParam;
import com.example.demo.test.entity.SysUserUpdateParam;
import com.example.demo.test.entity.SysUserQueryParam;

import com.example.demo.test.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonPage;
import java.util.List;
/**
* 用户信息表
* @author lyc
* @date 2022-04-07 10:39:36
*/
@Api(tags={"用户信息表操作接口"})
@RestController
public class SysUserController{

    @Autowired
    private SysUserService sysUserService;

    /**
    *  用户信息表 分页查询
    */
    @ApiOperation("用户信息表分页列表")
    @GetMapping("api/v1/sysUser/page")
    public CommonResult<CommonPage<SysUser>> pageSysUser(SysUserQueryParam sysUserQueryParam){
        CommonPage page = sysUserService.page(sysUserQueryParam);
        return  CommonResult.success(page);
    }



    /**
    *  id删除
    */
    @ApiOperation(value = "id删除")
    @PostMapping("api/v1/sysUserById/delete")
    public CommonResult delete(@Validated SysUserDeleteParam  sysUserDeleteParam){
        Boolean success = sysUserService.delete(sysUserDeleteParam);
        return  CommonResult.success(success);
    }


    /**
    *  用户信息表更新
    */
    @ApiOperation(value = "用户信息表更新")
    @PostMapping("api/v1/sysUser/update")
    public CommonResult update(@Validated SysUserUpdateParam  sysUserUpdateParam){
        Boolean success = sysUserService.update(sysUserUpdateParam);
        return  CommonResult.success(success);
    }

    /**
    *  用户信息表添加
    */
    @ApiOperation(value = "用户信息表添加")
    @PostMapping("api/v1/sysUser/add")
    public CommonResult add(@Validated SysUserAddParam  sysUserAddParam){
        Boolean success = sysUserService.add(sysUserAddParam);
        return  CommonResult.success(success);
    }
}