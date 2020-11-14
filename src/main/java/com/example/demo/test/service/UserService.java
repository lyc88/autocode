package com.example.demo.test.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.demo.aspect.LogAnno;
import com.example.demo.test.entity.User;
/**
* 
*
* @author lyc
* @date 2020-07-01 17:19:03
*/

public interface UserService extends IService<User>{

   boolean saveU(User u) throws Exception;

   public String ttt();
   //最终要执行该方法
   public String x(String res);

}