package com.example.testFullCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestFullCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFullCrudApplication.class, args);

		System.out.println("Application Running successfully on port:: 8080");
	}

}
