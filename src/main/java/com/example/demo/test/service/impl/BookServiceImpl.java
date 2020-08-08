package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.Book;
import com.example.demo.test.service.BookService;
import com.example.demo.test.mapper.BookMapper;
/**
* 
*
* @author lyc
* @date 2020-08-08 12:57:38
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements  BookService{

}