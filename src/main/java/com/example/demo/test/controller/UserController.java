package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 用户名
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@RestController
public class UserController{

    @Autowired
    private UserService userService;

    /**
    * 列表
    */
    @RequestMapping("user/list")
    public CommonResult<User> list(){
        List<User> users = userService.list(new QueryWrapper<User>());
        return new CommonResultResponse<List<User>>().ok(users);
    }

    /**
    *  id删除
    */
    @RequestMapping("user/delete")
    public CommonResult<User> delete(Integer id){
        Boolean success = userService.removeById(id);
        return new CommonResultResponse<Boolean>().ok(success);
    }

    /**
    *  id查询
    */
    @RequestMapping("user/findById")
    public CommonResult<User> findById(Integer id){
        User user = userService.getById(id);
        return new CommonResultResponse<User>().ok(user);
    }

     /**
      *  新增
      */
     @RequestMapping("user/findById")
     public CommonResult<User> add(User user){
        Boolean success = userService.save(user);
        return new CommonResultResponse<Boolean>().ok(success);
     }
}