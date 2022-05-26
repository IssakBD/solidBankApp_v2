package com.example.solidbankapp.entity;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.service.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    @Autowired
    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount){
        accountDepositService.deposit(account, amount);
    }
}
