package com.example.advancedHibernate;

import com.example.advancedHibernate.DAOs.AppDAO;
import com.example.advancedHibernate.Entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedHibernateApplication.class, args);

	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			System.out.println("App running and working fine.....");

			//createStudentWithCourses(appDAO);
//			createCourseWithStudents(appDAO);
//			findStudentsWithCourses(appDAO);
//			updateCourses(appDAO);

			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theID = 10;
		System.out.println("Deleting the course.....");
		appDAO.deleteCourseByID(theID);
		System.out.println("DONE!.");
	}

	private void updateCourses(AppDAO appDAO) {
		int theID= 2;
		System.out.println("Get the target student first...");
		Student student = appDAO.findStudentWithCoursesByStudentID(theID);

		System.out.println("Adding new courses the target student......");
		student.addCourse(new Course("Data structure & algorithms."));
		student.addCourse(new Course("Networking and siwetching"));

		System.out.println("Update the DB tables.....");
		appDAO.updateStudentCourses(student);
		System.out.println("DONE!.");

	}

	private void findStudentsWithCourses(AppDAO appDAO) {
		int theID = 1;
		System.out.println("Fetching the student............");
		Student result = appDAO.findStudentWithCoursesByStudentID(theID);

		System.out.println("Student data: " + result);
		System.out.println("The associated courses: " + result.getCourses());

	}

	private void createCourseWithStudents(AppDAO appDAO) {
		System.out.println("Create new course .......");
		Course course= new Course("OS every thing you need to know.");

		System.out.println("Create a new students.......");
		course.addStudent(new Student("Hend","Yassien","hend@gmail.com"));
		course.addStudent(new Student("joe","may","joe@gmail.com"));
		course.addStudent(new Student("andraw","maxy","andraw@gmail.com"));

		System.out.println("Persist the course  with students the  on the DB.....");
		appDAO.createCourseWithStudents(course);
		System.out.println("DONE!.");


	}

	private void createStudentWithCourses(AppDAO appDAO) {
		System.out.println("Create a new student.......");
		Student student= new Student("Ali", "Mahmoud", "ali@gmail.com");

		System.out.println("Create new courses .......");
		student.addCourse(new Course("Java the ultimate course."));
		student.addCourse(new Course("Nodejs the best one ever made"));
		student.addCourse(new Course("ReactJs ..... coool "));

		System.out.println("Persist the student with the courses on the DB.....");
		appDAO.CreateStudentWithCourses(student);
		System.out.println("DONE!.");
	}

	private void getCourse(AppDAO appDAO) {
		System.out.println("Getting course by ID.......");
		Course theCourse = appDAO.getCourseByID(10);

		System.out.println(theCourse);
		System.out.println("The reviews .....");
		System.out.println(theCourse.getReviews());
	}

	private void createCourseWithReviewsHandler(AppDAO appDAO) {
		System.out.println("Create the course....");
		Course theCourse=  new Course("nodejs");

		System.out.println("Create the reviews....");
		theCourse.addReviews(new Review("Very good course"));
		theCourse.addReviews(new Review("Nice one mate"));
		theCourse.addReviews(new Review("Very cool one jonas"));

		System.out.println("Saving them.......");
		appDAO.createCourseWithReviews(theCourse);
		System.out.println("DONE!");

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
		// 2) fetch the courses in independent way and then set it in the instructor manually

		System.out.println("--------fetching courses------------");
		List<Course> courses =appDAO.getCoursesByInstructorID(theID);

		System.out.println("-------- courses------------");
		//  to be able to execute this step, you have to make the fetch 'LAZY'
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
