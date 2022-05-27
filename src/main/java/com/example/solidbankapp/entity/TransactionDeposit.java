package com.example.solidbankapp.entity;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.service.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        accountDepositService.deposit(account, amount);
        transactionDAO.addTransactions("Deposit", amount, account.getFullAccountID(), account.getClientID(),true, dtf.format(now));
    }
}
