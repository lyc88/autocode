package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import com.example.demo.test.mapper.UserMapper;
/**
* 用户名
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements  UserService{

}