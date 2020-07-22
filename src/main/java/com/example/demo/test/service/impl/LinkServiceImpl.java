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
* @date 2020-07-20 17:51:51
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper,Link> implements  LinkService{

}