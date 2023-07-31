package com.example.advancedHibernate.Entities;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
