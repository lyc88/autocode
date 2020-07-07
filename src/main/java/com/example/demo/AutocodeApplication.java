package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AutocodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocodeApplication.class, args);
	}

}
