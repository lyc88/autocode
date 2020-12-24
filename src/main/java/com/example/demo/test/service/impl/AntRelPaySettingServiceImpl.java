package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.test.entity.AntRelPaySetting;
import com.example.demo.test.service.AntRelPaySettingService;
import com.example.demo.test.mapper.AntRelPaySettingMapper;
/**
* 蚂蚁门店 支付配置关联
*
* @author lyc
* @date 2020-12-24 14:04:43
*/
@Service
public class AntRelPaySettingServiceImpl extends ServiceImpl<AntRelPaySettingMapper,AntRelPaySetting> implements  AntRelPaySettingService{

}