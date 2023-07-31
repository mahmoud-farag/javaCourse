package com.example.advancedHibernate;

import com.example.advancedHibernate.DAOs.AppDAO;
import com.example.advancedHibernate.Entities.Course;
import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedHibernateApplication.class, args);
		System.out.println("App running and working fine.....");

	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {

//			createNewinstructor(appDAO);

//			findInstructorByID(appDAO);

//			findInstructorDetailsByID(appDAO);

//			createNewInstructorWithCourses(appDAO);\

			// ---FIRST WAY---- you have to change the fetch to be 'EAGER'
//			findinstructorWithCourses(appDAO);

			// ---SECOND WAY---- the fetch must be the default (LAZY)
//			findCourseByInstructorIDV2(appDAO);

			// 	---THIRD WAY----- make a custom JPQL query that fetching the instructor and courses together
			// in a single  db call (the default fetch her is lazy as it is ).
//			findInstructorWithCoursesJoinFetchV3(appDAO);


			removeInstructorById(appDAO);
		};
	}

	private void removeInstructorById(AppDAO appDAO) {

		System.out.println("Removing instructor by ID.....");
		appDAO.deleteInstructorById(1);
		System.out.println("Instructor remove successfully.....");
	}

	private void findInstructorWithCoursesJoinFetchV3(AppDAO appDAO) {

		System.out.println("Fetching the instructor.......");
		Instructor instructor =  appDAO.findInstructorWithCoursesJoinFetch(1);

		System.out.println("Her is  the instructor.......");
		System.out.println(instructor);


		System.out.println("Her is  the instructorDetails.......");
		System.out.println(instructor.getInstructorDetail());

		System.out.println("--------her is the courses------------");
		System.out.println(instructor.getCourses());

	}

	private void findCourseByInstructorIDV2(AppDAO appDAO) {

		int theID = 1;
		System.out.println("Fetching the instructor.......");
		Instructor instructor =  appDAO.findInstructorByID(theID);

		System.out.println("Her is  the instructor.......");
		System.out.println(instructor);


		System.out.println("Her is  the instructorDetails.......");
		System.out.println(instructor.getInstructorDetail());

		// another solution  is to 1) fetch the instructor (without changing the  default fetch)
		// 2) fetch the courses independent way and then set it in the instructor manaually

		System.out.println("--------fetching courses------------");
		List<Course> courses =appDAO.getCoursesByInstructorID(theID);

		System.out.println("-------- courses------------");
		//  to be able to execute this step you have to make the fetch 'LAZY'
		instructor.setCourses(courses);
		System.out.println(instructor.getCourses());
	}

	private void findinstructorWithCourses(AppDAO appDAO) {

		int theID = 1;
		System.out.println("Fetching the instructor.......");
		Instructor instructor =  appDAO.findInstructorByID(theID);

		System.out.println("Her is  the instructor.......");
		System.out.println(instructor);


		System.out.println("Her is  the instructorDetails.......");
		System.out.println(instructor.getInstructorDetail());

		// the relationship between the instructor & the courses is OneToMany this means that the default fetch is
		// 'LAZY' so this line will throw exception ... to solve this error you have to explicitly changing the
		//  fetch type to be 'EAGER'
		System.out.println("Her is the Courses.......");
		System.out.println(instructor.getCourses());



	}

	private void createNewInstructorWithCourses(AppDAO appDAO) {
		System.out.println("Creating instructor object.....");

		Instructor instructorInstance = new Instructor("Youssef", "Mahamad", "youssef@gmail.com");

		System.out.println("Creating InstructorDetail object....");
		InstructorDetails  instructorDetailsInstance =  new InstructorDetails("https://tennis.com", "tennis");

		System.out.println("Set InstructorDetail on the Instructor object....");
		instructorInstance.setInstructorDetail(instructorDetailsInstance);


		System.out.println("Creating the courses...");

		Course course1 =  new Course("Java-ee");
		Course course2 =  new Course("Nodejs");
		Course course3 =  new Course("Reactjs");

		instructorInstance.addCourse(course1);
		instructorInstance.addCourse(course2);
		instructorInstance.addCourse(course3);


		System.out.println("saving the courses...");
		//  as we activate the cascading option one this line of code will do the following stuff
		// 1)  save the instructorDetails, 2) save the instructor, 3) save the courses, as we said thanks to the cascade option
		appDAO.persist(instructorInstance);
		System.out.println("Done.........");

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
