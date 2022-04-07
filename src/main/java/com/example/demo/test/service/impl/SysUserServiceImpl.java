package com.example.demo.test.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.test.entity.SysUser;
import com.example.demo.test.service.SysUserService;
import com.example.demo.test.mapper.SysUserMapper;
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
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements  SysUserService{

    @Override
    public CommonPage<SysUser> page(SysUserQueryParam sysUserQueryParam){
        Integer pageNum = sysUserQueryParam.getPageNum();
        Integer pageSize = sysUserQueryParam.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        LambdaQueryWrapper<SysUser> lambda = new QueryWrapper<SysUser>().lambda();
        queryCondition(lambda,sysUserQueryParam);
        List<SysUser> sysUserList = list(lambda);
        CommonPage<SysUser> sysUserCommonPage = CommonPage.restPage(sysUserList);
        return sysUserCommonPage;
    }

    private void queryCondition(LambdaQueryWrapper<SysUser> lambda,SysUserQueryParam sysUserQueryParam){

        lambda.orderByDesc(SysUser::getUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(SysUserAddParam sysUserAddParam){
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserAddParam,sysUser);
        save(sysUser);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(SysUserUpdateParam sysUserUpdateParam){
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserUpdateParam,sysUser);
        updateById(sysUser);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(SysUserDeleteParam sysUserDeleteParam){
        removeById(sysUserDeleteParam.getUserId());
        return true;
    }
}