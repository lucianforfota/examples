package com.jpa.examples.studentcourse.v1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
