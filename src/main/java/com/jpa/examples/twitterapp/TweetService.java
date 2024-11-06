package com.jpa.examples.twitterapp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void deleteTweet(Long tweetId){
        tweetRepository.deleteById(tweetId);
    }

    public List<Tweet> findAllTweetsByUserId(Long userId){
        return tweetRepository.findAllByUser_Id(userId);
    }

    @Transactional
    public List<Tweet> findAllTweetsByUserId2(Long userId) throws Exception{
        User user = userRepository.findById(userId).orElseThrow(()->new Exception("used not found"));
        return user.getTweets();
    }

    public List<Tweet> findAllTweetsByUserId3(Long userId){
        List<Tweet> allTweets = tweetRepository.findAll();
        return allTweets.stream()
                .filter(tweet -> tweet.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }








}
