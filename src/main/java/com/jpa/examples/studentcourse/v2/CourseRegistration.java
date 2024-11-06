package com.jpa.examples.studentcourse.v2;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CourseRegistration {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @Column
    private LocalDate registeredAt;


}
