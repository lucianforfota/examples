package com.jpa.examples.studentcourse.v2;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "student")
    private List<CourseRegistration> registrations;
}
