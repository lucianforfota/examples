package com.jpa.examples.accountapp;

import com.jpa.examples.Order;
import com.jpa.examples.OrderRepository;
import com.jpa.examples.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    private AccountService accountService;
    private AccountRepository accountRepository;

    @Autowired
    public Runner(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Account account1 = new Account(100);
        Account account2 = new Account(100);
        accountRepository.save(account1);
        accountRepository.save(account2);

        accountService.transfer(1L,2L,101);


    }
}
