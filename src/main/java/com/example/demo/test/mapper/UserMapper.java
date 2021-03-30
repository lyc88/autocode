package com.example.demo.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.test.entity.User;
/**
* 
*
* @author lyc
* @date 2021-03-30 16:43:10
*/
@Mapper
public interface UserMapper extends BaseMapper<User>{

}