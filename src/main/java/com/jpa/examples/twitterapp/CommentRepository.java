package com.jpa.examples.twitterapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTweet_Id(Long tweetId);
    List<Comment> findAllByTweet_User_Id(Long userId);
    List<Comment> findAllByText(String text);
}
