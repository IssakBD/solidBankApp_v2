package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountListingService;
import com.example.solidbankapp.service.AccountListingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    @Autowired
    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) throws Exception {
       bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
    };

    public void getAccounts(String clientID){
        System.out.println(accountListing.getClientAccounts(clientID));
    };


}
