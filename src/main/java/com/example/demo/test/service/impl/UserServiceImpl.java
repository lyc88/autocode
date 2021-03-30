package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import com.example.demo.test.mapper.UserMapper;
/**
* 
*
* @author lyc
* @date 2021-03-30 16:43:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements  UserService{

}