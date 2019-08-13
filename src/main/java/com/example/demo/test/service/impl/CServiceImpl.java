package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.C;
import com.example.demo.test.service.CService;
import com.example.demo.test.mapper.CMapper;
/**
* 
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Service
public class CServiceImpl extends ServiceImpl<CMapper,C> implements  CService{

}