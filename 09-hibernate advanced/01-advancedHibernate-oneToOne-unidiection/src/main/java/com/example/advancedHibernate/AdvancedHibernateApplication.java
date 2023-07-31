package com.example.advancedHibernate;

import com.example.advancedHibernate.DAOs.InstructorDAO;
import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedHibernateApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instractorDAO) {

		return runner -> {

			createNewinstructor(instractorDAO);

			findInstructorByID(instractorDAO);
		};
	}

	private void findInstructorByID(InstructorDAO instractorDAO) {
		int instructorID= 1;

		System.out.println("Fetching the instructor.....");
		Instructor instructor = instractorDAO.findByID(instructorID);
		System.out.println("::: her is the instructor:");
		System.out.println(instructor);

		System.out.println(":::: her is the instructorDetails:");
		System.out.println(instructor.getInstructorDetail());

	}

	private void createNewinstructor(InstructorDAO instractorDAO) {

		System.out.println("Creating instructor object.....");
		Instructor instructorInstance = new Instructor("Youssef", "Mahamad", "youssef@gmail.com");

		System.out.println("Creating InstructorDetail object....");
		InstructorDetails  instructorDetailsInstance =  new InstructorDetails("https://tennis.com", "tennis");

		System.out.println("Set InstructorDetail on the Instructor object....");
		instructorInstance.setInstructorDetail(instructorDetailsInstance);

		instractorDAO.persist(instructorInstance);

		System.out.println("Instructor save and cascading the InstructorDetail...");


	}
}
