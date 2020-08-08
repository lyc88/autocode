package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.Link;
import com.example.demo.test.service.LinkService;
import com.example.demo.test.mapper.LinkMapper;
/**
* 
*
* @author lyc
* @date 2020-08-04 22:54:30
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper,Link> implements  LinkService{

}