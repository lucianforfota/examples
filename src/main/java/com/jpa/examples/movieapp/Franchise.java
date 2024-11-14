package com.jpa.examples.movieapp;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Franchise {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "franchise")
    private List<Movie> movies;

    public Franchise() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
