package com.jpa.examples.accountapp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackOn=Exception.class)
    public void transfer(Long fromAccountId, Long toAccountId, Integer amount) throws Exception {
        //aduca din db cele 2 countri
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new Exception("account not found"));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(() -> new Exception("account not found"));
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(toAccount);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountRepository.save(fromAccount);
    }
}
