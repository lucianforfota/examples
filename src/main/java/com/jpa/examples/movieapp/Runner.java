package com.jpa.examples.movieapp;

import com.jpa.examples.accountapp.Account;
import com.jpa.examples.accountapp.AccountRepository;
import com.jpa.examples.accountapp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private MovieService movieService;

    @Autowired
    public Runner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        Character character = new Character("superman");

        movieService.addCharacterToMovie(character, 1L);
    }
}
