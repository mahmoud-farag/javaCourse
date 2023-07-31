package com.springboot.CRUDdemo.DAO;

import com.springboot.CRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentInterface{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        this.entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName DESC ", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theFirstName) {

        // 1) build query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:theParam", Student.class);

        // 2) set the parameter
        theQuery.setParameter("theParam", theFirstName);

        // 3) execute the query
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(int id) {
        // 1) find the student
        Student std = entityManager.find(Student.class, id);
        System.out.println(std);
        entityManager.remove(std);
    }
}
