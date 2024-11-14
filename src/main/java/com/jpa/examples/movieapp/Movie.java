package com.jpa.examples.movieapp;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="franchise_id")
    private Franchise franchise;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="movie_character",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="character_id")
    )
    private List<Character> characters;

    public Movie() {}

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

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public List<Character> getCharacters() {
        if (characters==null){
            characters=new ArrayList<>();
        }
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
