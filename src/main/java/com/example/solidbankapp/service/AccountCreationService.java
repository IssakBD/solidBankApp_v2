package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.AccountType;

public interface AccountCreationService {
    public void create(AccountType accountType, long bankID, String clientID, long accountID);
}
