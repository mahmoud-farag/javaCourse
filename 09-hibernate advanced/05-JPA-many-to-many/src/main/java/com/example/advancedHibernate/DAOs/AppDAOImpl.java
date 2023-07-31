package com.example.advancedHibernate.DAOs;

import com.example.advancedHibernate.Entities.Course;
import com.example.advancedHibernate.Entities.Instructor;
import com.example.advancedHibernate.Entities.InstructorDetails;
import com.example.advancedHibernate.Entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        // this step is very important to avid this error
        //SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails

        List<Course>  courses =  instructor.getCourses();

        for(Course c: courses) {
            // detach the instructor from the course to be able to remove it without removing the courses
            // and also to be able to avoid the above err.

            c.setInstructor(null);
        }
        // instructorDetails in a OneToOne relationShip with tthe instructor so this means that the associated
        // instructorDetails will also removed implicitly
        entityManager.remove(instructor);
    }

    @Override
    public Instructor findInstructorByID(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Course> getCoursesByInstructorID(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructorFiled.id = :theID", Course.class);
        query.setParameter("theID", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorWithCoursesJoinFetch(int id) {

        // the qlString her is not SQL query... it's a special JPQL query using the java entities instead of the
        // actual database tables and fields.
        TypedQuery<Instructor> query = entityManager.createQuery(
                                "select i from Instructor i "
                                       +  "JOIN FETCH i.courses "
                                        +  "where i.id = :theID", Instructor.class);

        query.setParameter("theID", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void createCourseWithReviews(Course theCourse) {

        // this line will save the course and its associated reviews thanks to the cascadetype=ALL
        entityManager.persist(theCourse);
    }

    @Override
    public Course getCourseByID(int id) {
        // FIRST-WAY need you activate the EAGER type
       // return  entityManager.find(Course.class, id);

        // SECOND-WAY does not need you to use the Eager fetch
        TypedQuery<Course> query =  entityManager.createQuery(
                "select c from Course c " +
                        " JOIN FETCH c.reviews " +
                        "where c.id = :theID"
                        , Course.class);
        query.setParameter("theID", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void CreateStudentWithCourses(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional

    public void createCourseWithStudents(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Student findStudentWithCoursesByStudentID(int id) {

        // 1) build the query
         TypedQuery<Student> query = entityManager.createQuery(
                            "select s from Student s " +
                                    "JOIN FETCH s.courses " +
                                    " where s.id = :theID ",
                                    Student.class );

        // 2) set the parameter
         query.setParameter("theID", id);
        // 3) return the result
         return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudentCourses(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteCourseByID(int id) {
        // 1) get the targetCourse
        Course theCourse =  entityManager.find(Course.class, id);
        // 2) remove it.
        entityManager.remove(theCourse);
    }

    @Override
    public InstructorDetails findByID(int id) {
        return entityManager.find(InstructorDetails.class, id);
    }
}