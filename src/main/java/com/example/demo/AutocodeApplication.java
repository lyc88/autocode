package com.example.demo;

import com.jctech.framework.boot.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCanalClient
public class AutocodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocodeApplication.class, args);
	}

}
