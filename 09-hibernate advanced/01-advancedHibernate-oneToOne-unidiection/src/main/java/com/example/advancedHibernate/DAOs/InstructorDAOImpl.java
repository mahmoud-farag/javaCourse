package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class InstructorDAOImpl implements InstructorDAO {

    private EntityManager entityManager;

    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void persist(Instructor instructor) {

        entityManager.persist(instructor);
    }

    @Override
    public Instructor findByID(int id) {
        return entityManager.find(Instructor.class, id);
    }
}
