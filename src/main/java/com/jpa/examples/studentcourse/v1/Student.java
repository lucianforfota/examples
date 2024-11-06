package com.jpa.examples.studentcourse.v1;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToMany
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses;
}
