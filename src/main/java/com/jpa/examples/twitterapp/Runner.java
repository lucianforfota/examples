package com.jpa.examples.twitterapp;

import com.jpa.examples.accountapp.Account;
import com.jpa.examples.accountapp.AccountRepository;
import com.jpa.examples.accountapp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private UserService userService;


    private TweetService tweetService;

    @Autowired
    public Runner(UserService userService, TweetService tweetService) {
        this.userService = userService;
        this.tweetService=tweetService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Costel");
        User savedUser = userService.addUser(user);
        Tweet tweet = new Tweet("iara ninge");
        Tweet savedTweet  = userService.addTweetToUser(tweet, savedUser.getId());
        System.out.println(tweetService.findAllTweetsByUserId(savedUser.getId()));
        //userService.deleteAllTweetsFromUser(1L);
        tweetService.deleteTweet(savedTweet.getId());
        System.out.println(tweetService.findAllTweetsByUserId(savedUser.getId()));
    }
}

