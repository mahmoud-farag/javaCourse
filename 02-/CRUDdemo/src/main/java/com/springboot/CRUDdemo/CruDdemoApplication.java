package com.springboot.CRUDdemo;

import com.springboot.CRUDdemo.DAO.StudentInterface;
import com.springboot.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentInterface studentDAO) {
		return runner -> {
			System.out.println("Hello Hibernate!!");
			// 1) create and save a student
			// saveStudent(studentDAO);

			// 2) search for a student via ID
			// findStudent(studentDAO, 1);

			// 3) Get all Students
			// getAllStudents(studentDAO);


			// 4) get students by firstName
			// getStudentsByFirstName("ali", studentDAO);

			// 5) update student
			// findOneAndUpdate(2, studentDAO, "Joe");


			// 6) remove student
			findOneAndRemove(2, studentDAO);
		};
	}


	private void saveStudent (StudentInterface studentDAO) {
		// 1) create student entity
		System.out.println("Create student instance.....");
		Student studentInstance = new Student("hend", "ahmed", "hend@gmail.com");

		System.out.println("Persist student to the DB.....");
		// 2) save the student
		studentDAO.save(studentInstance);


		// 3) print the ID
		System.out.println("Print student ID.....");
		System.out.println("Student ID is: " + studentInstance.getId());


	}

	private void findStudent(StudentInterface studentDAO, int id) {
		Student student = studentDAO.findByID(id);

		System.out.println("FindById a certain student.....");
		System.out.println(student);
	}

	private void getAllStudents (StudentInterface studentDAO) {
		List<Student> students =  studentDAO.findAll();

		for (Student stud : students) {
			System.out.println(stud);
		}
	}

	private void getStudentsByFirstName(String firstName, StudentInterface studentDAO) {
		List<Student> students =  studentDAO.findByLastName(firstName);

		System.out.println("Find student by firstName.....");
		for (Student stud : students) {
			System.out.println(stud);
		}
	}

	private void findOneAndUpdate(int id,StudentInterface studentDAO, String lastName) {

		System.out.println("Getting student for updating....");
		Student  selectedStudent =  studentDAO.findByID(1);

		System.out.println("prepare for updating....");
		selectedStudent.setLastName(lastName);

		studentDAO.update(selectedStudent);
		System.out.println("Student updated...");
	}

	private void findOneAndRemove(int id, StudentInterface studentDAO){
//		System.out.println("fetching student before deleting...");
//
//		Student student = studentDAO.findByID(id);
//
//		System.out.println("Student before deleting...");
//		System.out.println(student);
		studentDAO.remove(id);
		System.out.println("Student  deleted...");

	}
}
