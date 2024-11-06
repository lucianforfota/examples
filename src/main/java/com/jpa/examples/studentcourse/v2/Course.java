package com.jpa.examples.studentcourse.v2;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "course")
    private List<CourseRegistration> registrations;
}
