package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.TUnit;
import com.example.demo.test.service.TUnitService;
import com.example.demo.test.mapper.TUnitMapper;
/**
* 产品单位
*
* @author lyc
* @date 2020-03-26 18:09:39
*/
@Service
public class TUnitServiceImpl extends ServiceImpl<TUnitMapper,TUnit> implements  TUnitService{

}