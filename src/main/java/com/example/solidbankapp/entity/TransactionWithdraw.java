package com.example.solidbankapp.entity;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    @Autowired
    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }



    public void execute(AccountWithdraw accountWithdrawFrom, AccountWithdraw accountWithdrawTo, double amount){

    }
    public void execute(AccountWithdraw accountWithdraw, double amount){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        boolean transactionStatus = accountWithdrawService.withdraw(amount, accountWithdraw);
        transactionDAO.addTransactions("Withdraw", amount, accountWithdraw.getFullAccountID(), accountWithdraw.getClientID(), transactionStatus, dtf.format(now));
    }

}
