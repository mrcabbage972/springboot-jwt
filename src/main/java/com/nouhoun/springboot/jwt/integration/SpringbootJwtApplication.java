package com.nouhoun.springboot.jwt.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
		System.out.println("Spring Boot JWT Application Started Successfully!");
	}
}