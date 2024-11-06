package com.jpa.examples.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    private TweetService tweetService;

    @Autowired
    public CommentService(CommentRepository commentRepository, TweetService tweetService) {
        this.commentRepository = commentRepository;
        this.tweetService=tweetService;
    }

    public List<Comment> findAllCommentsByTweet(Long tweetId){
        return commentRepository.findAllByTweet_Id(tweetId);
    }

    public List<Comment> findAllCommentsByUserId(Long userId){
        return commentRepository.findAllByTweet_User_Id(userId);
    }

    public List<Comment> findAllCommentsByUserId2(Long userId){
        List<Tweet> tweetsByUser = tweetService.findAllTweetsByUserId(userId);
        return tweetsByUser.stream()
                .flatMap(tweet -> tweet.getComments().stream())
                .collect(Collectors.toList());

        //var parcurgere clasica
        /*List<Comment> result = new ArrayList<>();
        for (Tweet tweet: tweetsByUser){
            result.addAll(tweet.getComments());
        }
        return result;*/
    }

    public List<Comment> findAllCommentsByUserId3(Long userId){
        List<Comment> allComments = commentRepository.findAll();
        return allComments.stream()
                .filter(comment -> comment.getTweet().getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
