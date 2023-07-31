package com.springboot.CRUDdemo.DAO;

import com.springboot.CRUDdemo.entity.Student;

import java.util.List;

public interface StudentInterface {

    void save(Student theStudent);
    Student findByID(int id);
    List<Student> findAll();
    List<Student> findByLastName(String theFirstName);

    void update(Student student);

    void remove (int  id);
}
