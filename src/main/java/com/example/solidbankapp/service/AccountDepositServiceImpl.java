package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl implements AccountDepositService{
    AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
//        Account newAcc = account;
//        newAcc.setBalance(account.getBalance() + amount);
//        accountDAO.updateAccount(account, newAcc);
//        System.out.printf("%.2f$ transferred to %s account \n", amount, newAcc.getId());
        accountDAO.updateBalance(accountDAO.getBalance(account.getFullAccountID()) + amount, account.getFullAccountID());
    }
}
