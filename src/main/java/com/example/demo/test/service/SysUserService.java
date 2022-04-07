package com.example.demo.test.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.demo.test.entity.SysUser;
import com.example.demo.test.entity.SysUserAddParam;
import com.example.demo.test.entity.SysUserDeleteParam;
import com.example.demo.test.entity.SysUserUpdateParam;
import com.example.demo.test.entity.SysUserQueryParam;

import com.example.demo.bean.CommonPage;
/**
* 用户信息表
*
* @author lyc
* @date 2022-04-07 10:39:37
*/

public interface SysUserService extends IService<SysUser>{

    CommonPage<SysUser> page(SysUserQueryParam sysUserQueryParam);

    Boolean add(SysUserAddParam sysUserAddParam);

    Boolean update(SysUserUpdateParam sysUserUpdateParam);

    Boolean delete(SysUserDeleteParam sysUserDeleteParam);
}