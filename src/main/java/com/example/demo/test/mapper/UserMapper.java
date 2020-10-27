package com.example.demo.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.test.entity.User;

import java.util.Map;

/**
* 
*
* @author lyc
* @date 2020-07-01 17:19:03
*/
@Mapper
public interface UserMapper extends BaseMapper<User>{

    public Map  selectDeviceToken(Map<String, Object> params);

}