package com.jpa.examples.twitterapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {

    void deleteAllByUser_Id(Long userId);
    List<Tweet> findAllByUser_Id(Long userId);
}
