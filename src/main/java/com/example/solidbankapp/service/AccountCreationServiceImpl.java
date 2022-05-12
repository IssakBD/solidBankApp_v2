package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.*;

public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;
    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        if (accountType.equals(AccountType.FIXEDACCOUNT)) {
            accountDAO.createNewAccount(new FixedAccount(accountType, String.valueOf(accountID), clientID, 0, false));
        }
        else if (accountType.equals(AccountType.CHECKINGACCOUNT)) {
            accountDAO.createNewAccount(new CheckingAccount(accountType, String.valueOf(accountID), clientID, 0, true));
        }
        else if (accountType.equals(AccountType.SAVINGACCOUNT)) {
            accountDAO.createNewAccount(new SavingAccount(accountType, String.valueOf(accountID), clientID, 0, true));
        }

    }

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
