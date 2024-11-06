package com.jpa.examples.twitterapp;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tweet {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @ManyToOne
    //@JoinColumn se pune unde avem many. coloana user_id se va crea in baza de date cand creem tweetul
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy="tweet")
    private List<Comment> comments;

    public Tweet(){

    }

    public Tweet(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user;
    }
}
