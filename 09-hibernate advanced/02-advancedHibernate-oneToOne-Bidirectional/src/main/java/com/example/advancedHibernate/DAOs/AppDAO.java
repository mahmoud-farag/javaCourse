package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;

public interface AppDAO {
    InstructorDetails findByID (int id);

    public void persist (Instructor instructor);

    public Instructor findInstructorByID (int id);
}
