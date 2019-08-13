package com.example.demo.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.test.entity.User;
/**
* 用户名
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Mapper
public interface UserMapper extends BaseMapper<User>{

}