package com.example.solidbankapp.entity;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
            accountWithdrawService.withdraw(amount, accountWithdraw);
    }

}
