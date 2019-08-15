package com.example.demo;

import com.example.demo.mapper.MysqlMapper;
import com.example.demo.service.MysqlAutoService;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutocodeApplicationTests {

	@Autowired
	private MysqlAutoService mysqlAutoService;


	@Test
	public void contextLoads() throws IOException, TemplateException {

			mysqlAutoService.autoCode("user");

	}

}
