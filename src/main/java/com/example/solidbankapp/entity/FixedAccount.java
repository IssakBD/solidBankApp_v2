package com.example.solidbankapp.entity;

public class FixedAccount extends AccountDeposit{
    public FixedAccount(String accountType, Long clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
