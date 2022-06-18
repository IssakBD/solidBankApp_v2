package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountCreationService;
import com.example.solidbankapp.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
//    private long lastAccountNumber = 1;

    private final AccountCreationService accountCreation;

    private final UserService userService;

    public BankCore(AccountCreationService accountCreation, UserService userService) {
        this.accountCreation = accountCreation;
        this.userService = userService;
    }

//    private void incrementLastAccountNumber(){
//        lastAccountNumber++;
//    }

    public void createNewAccount(AccountType accountType, Long clientID){
//            accountCreation.create(accountType, id, clientID, lastAccountNumber);
//            incrementLastAccountNumber();
        accountCreation.create(accountType, id, clientID);
    }
    public void createNewAccount(AccountType accountType, String username){
        UserEntity user = userService.getUserByUsername(username);
        accountCreation.create(accountType, id, Long.valueOf(user.getId()));
    }
};
