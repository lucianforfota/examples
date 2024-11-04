package com.jpa.examples.twitterapp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public UserService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository=tweetRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    //este o metoda mai sigura
    @Transactional
    public void addTweetToUser(Tweet tweet, Long userId) throws Exception{
        User user = userRepository.findById(userId).orElseThrow(()->new Exception("user not found"));
        tweet.setUser(user);
        tweetRepository.save(tweet);
    }

    //pentru a putea folosi aceasta metoda, in clasa User am folosit pt. atributul tweets "cascade = CascadeType.ALL"
    @Transactional
    public void addTweetToUser2(Tweet tweet, Long userId) throws Exception{
        User user = userRepository.findById(userId).orElseThrow(()->new Exception("user not found"));
        tweet.setUser(user);
        user.getTweets().add(tweet);
        userRepository.save(user);
    }

    public void deleteAllTweetsFromUser(Long userId){
        tweetRepository.deleteAllByUser_Id(userId);
    }
}
