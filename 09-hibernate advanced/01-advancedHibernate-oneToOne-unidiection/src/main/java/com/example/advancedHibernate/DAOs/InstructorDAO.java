package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Instructor;

public interface InstructorDAO {

    public void persist (Instructor instructor);

    public Instructor findByID (int id);
}
