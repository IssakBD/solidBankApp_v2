package com.example.solidbankapp.entity;

public class CheckingAccount extends AccountWithdraw{
    public CheckingAccount(String accountType, Long clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
