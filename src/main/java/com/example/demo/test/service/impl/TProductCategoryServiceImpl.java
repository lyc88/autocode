package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.TProductCategory;
import com.example.demo.test.service.TProductCategoryService;
import com.example.demo.test.mapper.TProductCategoryMapper;
/**
* 产品种类
*
* @author lyc
* @date 2020-03-26 18:08:51
*/
@Service
public class TProductCategoryServiceImpl extends ServiceImpl<TProductCategoryMapper,TProductCategory> implements  TProductCategoryService{

}