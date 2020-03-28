package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.TGoods;
import com.example.demo.test.service.TGoodsService;
import com.example.demo.test.mapper.TGoodsMapper;
/**
* 商品表
*
* @author lyc
* @date 2020-03-26 18:07:49
*/
@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper,TGoods> implements  TGoodsService{

}