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
* @date 2020-07-01 17:19:03
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements  UserService{

}