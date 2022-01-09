package com.hc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.cmeza.sdgenerator.annotation.SDGenerator;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class MtsSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtsSecurityApplication.class, args);
	}
	
}
