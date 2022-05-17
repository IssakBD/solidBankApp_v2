package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        if (accountType.equals(AccountType.FIXEDACCOUNT)) {
            accountDAO.createNewAccount(new FixedAccount(accountType, String.format("%03d%06d",1, accountID) , clientID, 0, false));
        }
        else if (accountType.equals(AccountType.CHECKINGACCOUNT)) {
            accountDAO.createNewAccount(new CheckingAccount(accountType, String.format("%03d%06d",1, accountID), clientID, 0, true));
        }
        else if (accountType.equals(AccountType.SAVINGACCOUNT)) {
            accountDAO.createNewAccount(new SavingAccount(accountType, String.format("%03d%06d",1, accountID), clientID, 0, true));
        }

    }

    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
