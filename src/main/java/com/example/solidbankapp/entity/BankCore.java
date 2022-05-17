package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountCreationService;
import com.example.solidbankapp.service.AccountListingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    @Autowired
    public BankCore(@Qualifier("accountCreationServiceImpl") AccountCreationService accountCreation) {
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
