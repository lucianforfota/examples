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

    @Autowired
    public Runner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Costel");
        userService.addUser(user);
        Tweet tweet = new Tweet("iara ninge");
        userService.addTweetToUser2(tweet,1L);
        userService.deleteAllTweetsFromUser(1L);
    }
}

