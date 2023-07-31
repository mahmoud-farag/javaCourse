package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class AppDAOImpl implements  AppDAO{

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void persist(Instructor instructor) {

        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorByID(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public InstructorDetails findByID(int id) {
        return entityManager.find(InstructorDetails.class, id);
    }
}
