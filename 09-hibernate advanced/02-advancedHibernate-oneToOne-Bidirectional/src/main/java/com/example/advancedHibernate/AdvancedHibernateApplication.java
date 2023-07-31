package com.example.advancedHibernate;

import com.example.advancedHibernate.DAOs.AppDAO;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {

//			createNewinstructor(appDAO);

//			findInstructorByID(appDAO);

//			findInstructorDetailsByID(appDAO);

			findInstructorWithCourses(appDAO);
		};
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;

		System.out.println("Fetching instructor.........");
		Instructor instructor = appDAO.findInstructorByID(1);

		System.out.println("-------Her is the instructor------");
		System.out.println(instructor);

		System.out.println("-------her is the instructorDetails-------");
		System.out.println(instructor.getInstructorDetail());

		System.out.println();
		System.out.println(instructor);
	}

	private void findInstructorDetailsByID(AppDAO appDAO) {

		int id = 1;
		System.out.println("Fetching the instructorDetails.....");
		InstructorDetails insDetails = appDAO.findByID(id);
		System.out.println("::: her is the instructorDetails:");
		System.out.println(insDetails);
		System.out.println(":::: her is the instructor:");
		System.out.println(insDetails.getInstructor());

	}

	private void findInstructorByID(AppDAO appDAO) {
		int instructorID= 1;

		System.out.println("Fetching the instructor.....");
		Instructor instructor = appDAO.findInstructorByID(instructorID);
		System.out.println("::: her is the instructor:");
		System.out.println(instructor);

		System.out.println(":::: her is the instructorDetails:");
		System.out.println(instructor.getInstructorDetail());

	}

	private void createNewinstructor(AppDAO appDAO) {

		System.out.println("Creating instructor object.....");
		Instructor instructorInstance = new Instructor("Youssef", "Mahamad", "youssef@gmail.com");

		System.out.println("Creating InstructorDetail object....");
		InstructorDetails  instructorDetailsInstance =  new InstructorDetails("https://tennis.com", "tennis");

		System.out.println("Set InstructorDetail on the Instructor object....");
		instructorInstance.setInstructorDetail(instructorDetailsInstance);

		appDAO.persist(instructorInstance);

		System.out.println("Instructor save and cascading the InstructorDetail...");


	}
}
