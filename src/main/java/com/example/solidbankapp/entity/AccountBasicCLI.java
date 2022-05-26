package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    @Autowired
    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, @Qualifier("accountListingServiceImpl") AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(Long clientID) throws Exception {
       bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
    }

    public void getAccounts(Long clientID){
        System.out.println(accountListing.getClientAccounts(clientID));
    }

}
