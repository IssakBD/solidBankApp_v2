package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountCreationService;
import com.example.solidbankapp.service.AccountListingServiceImpl;

public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    private void incrementLastAccountNumber(){
        lastAccountNumber++;
    }

    public void createNewAccount(AccountType accountType, String clientID){
            accountCreation.create(accountType, id, clientID, lastAccountNumber);
            incrementLastAccountNumber();
    }
};
