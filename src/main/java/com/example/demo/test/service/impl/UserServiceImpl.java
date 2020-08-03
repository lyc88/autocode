package com.example.demo.test.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import com.example.demo.test.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
* 
*
* @author lyc
* @date 2020-07-01 17:19:03
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements  UserService{



    @Transactional(rollbackFor = {Exception.class})
    @Override
    public boolean saveU(User u) throws Exception {
        User t = new User();
        //t.setId(111110);
        t.setName("132323231123233444");
        t.setAge(0);
        t.setCreateTime(new Date());
       // t.setLimit(0);
       // t.setPage(0);
        boolean save = save(t);
        if(save){
            throw new Exception("hhhe");
        }
        return false;
    }
}