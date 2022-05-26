package com.example.solidbankapp.entity;

public class SavingAccount extends AccountWithdraw{
    public SavingAccount(String accountType, Long clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
