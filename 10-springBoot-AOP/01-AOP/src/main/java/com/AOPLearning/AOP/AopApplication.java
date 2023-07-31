package com.AOPLearning.AOP;

import com.AOPLearning.AOP.DAO.AccountDAo;
import com.AOPLearning.AOP.DAO.AnotherDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {



	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
		System.out.println("App working fine on port 8080");

	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAo accountDAo, AnotherDAO anotherDAO) {

		return runner -> {
			System.out.println("App working fine on port 8080");

			doBeforeTheStuff(accountDAo, anotherDAO);
		};
	}

	private void doBeforeTheStuff(AccountDAo accountDAo, AnotherDAO anotherDAO) {

		accountDAo.addToAccount();
		System.out.println("\n--------------------------------------\n");
		anotherDAO.addNewUser();
	}

}
