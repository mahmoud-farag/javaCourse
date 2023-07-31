package com.example.RESTFULL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfullApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestfullApplication.class, args);

		System.out.println("APP running successfully on port:: 8080");
	}

}
