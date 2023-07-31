package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Course;
import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;
import com.example.advancedHibernate.Entities.Student;

import java.util.List;

public interface AppDAO {
    InstructorDetails findByID (int id);

     void persist (Instructor instructor);
     void deleteInstructorById(int id);

     Instructor findInstructorByID (int id);
     List<Course> getCoursesByInstructorID(int id);

     Instructor findInstructorWithCoursesJoinFetch(int id);

     void createCourseWithReviews(Course theCourse);
     Course getCourseByID(int id);
     void CreateStudentWithCourses(Student student);
     void createCourseWithStudents(Course course);

     Student findStudentWithCoursesByStudentID(int id);
     void updateStudentCourses(Student student);

     void deleteCourseByID(int id);

}