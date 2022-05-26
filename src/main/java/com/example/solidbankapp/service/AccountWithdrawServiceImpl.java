package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.AccountWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    AccountDAO accountDAO;

    @Autowired
    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        if(accountDAO.getBalance(account.getFullAccountID()) >= amount){
//            AccountWithdraw newAcc = account;
//            newAcc.setBalance(account.getBalance() - amount);
//            accountDAO.updateAccount(account, newAcc);
//            System.out.printf("%.2f$ transferred from %s account \n", amount, newAcc.getId());
            accountDAO.updateBalance(accountDAO.getBalance(account.getFullAccountID()) - amount, account.getFullAccountID());
        }
        else{
            System.out.println("You can't withdraw amount more than " + accountDAO.getBalance(account.getFullAccountID()));
        }
    }

}
