package com.example.solidbankapp.entity;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;

public abstract class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
