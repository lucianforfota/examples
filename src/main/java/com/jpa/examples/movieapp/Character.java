package com.jpa.examples.movieapp;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;


    @ManyToMany(mappedBy = "characters")
    private List<Movie> movies;

    public Character(String name) {
        this.name = name;
    }

    public Character() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        if(this.movies ==null){
            this.movies=new ArrayList<>();
        }
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
