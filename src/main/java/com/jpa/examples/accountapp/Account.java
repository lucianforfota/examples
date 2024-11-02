package com.jpa.examples.accountapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer balance;

    public Account( Integer balance) {
        this.balance = balance;
    }

    public Account() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) throws Exception{
        if (balance < 0){
            throw new Exception("soldul nu poate fi negativ");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
