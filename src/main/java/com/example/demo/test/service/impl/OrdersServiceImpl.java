package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.Orders;
import com.example.demo.test.service.OrdersService;
import com.example.demo.test.mapper.OrdersMapper;
/**
* 
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper,Orders> implements  OrdersService{

}