package com.example.solidbankapp.entity;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;

public class AccountWithdraw extends Account {
    public AccountWithdraw(String accountType, Long clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
