package com.ker.rsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class RsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsmApplication.class, args);
	}

}
