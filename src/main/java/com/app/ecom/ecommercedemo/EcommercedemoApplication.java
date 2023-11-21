package com.app.ecom.ecommercedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EcommercedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercedemoApplication.class, args);
	}

	@Bean
	@Scope("singleton")
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
