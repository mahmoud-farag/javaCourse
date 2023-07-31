package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Course;
import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;

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

}