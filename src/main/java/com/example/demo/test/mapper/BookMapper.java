package com.example.demo.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.test.entity.Book;
/**
* 
*
* @author lyc
* @date 2020-08-08 12:57:38
*/
@Mapper
public interface BookMapper extends BaseMapper<Book>{

}