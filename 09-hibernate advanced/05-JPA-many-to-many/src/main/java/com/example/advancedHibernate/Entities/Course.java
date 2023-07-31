package com.example.advancedHibernate.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    // by adding this cascade properties[DETACH,MERGE,PERSIST, REFRESH ]... we prevent deleting the instructor row if any of
    // the associated courses deleted
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    // her we have to make a link between the courses table and the instructors table via the 'instructor_id' in the courses table
    @JoinColumn(name= "instructor_id")
    private Instructor instructorFiled;


    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name="course_id")
    private List<Review> reviews;

    @ManyToMany (
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
    @JoinTable (
            name="course_student",
            joinColumns= @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    public Course () {}
    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructorFiled;
    }

    public void setInstructor(Instructor instructorFiled) {
        this.instructorFiled = instructorFiled;
    }

    public Instructor getInstructorFiled() {
        return instructorFiled;
    }

    public void setInstructorFiled(Instructor instructorFiled) {
        this.instructorFiled = instructorFiled;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReviews(Review theReview) {

        if( reviews == null) {
            reviews = new ArrayList<Review>();
        }

        reviews.add(theReview);
    }


    public void addStudent(Student theStudent) {

        if (students == null) {
            students =  new ArrayList<Student>();
        }

        students.add(theStudent);
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
