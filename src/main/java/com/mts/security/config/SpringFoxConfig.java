package com.mts.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;

@Configuration
public class SpringFoxConfig {
	
	@Bean
    public Docket api() { 
		
        return new Docket(DocumentationType.SWAGGER_2).host("localhost:8443").pathMapping("/")  
          .select() 
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())  
          .build();        
        
    }
}