package com.example.solidbankapp.entity;

public class AccountDeposit extends Account {
    public AccountDeposit(String accountType, Long clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
