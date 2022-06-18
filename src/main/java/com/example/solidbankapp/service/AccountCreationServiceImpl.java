package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService{

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void create(AccountType accountType, long bankID, Long clientID) {
        boolean isAccountCreated = false;
        Account account = null;
        if (accountType.equals(AccountType.FIXEDACCOUNT)) {
            account = new FixedAccount(accountType.toString(), clientID, 0, false);
            isAccountCreated = true;
        }
        else if (accountType.equals(AccountType.CHECKINGACCOUNT)) {
            account = new CheckingAccount(accountType.toString(), clientID, 0, true);
//            accountDAO.createNewAccount(new CheckingAccount(String.format("%03d%06d",1, accountID), accountType, clientID, 0, true));
            isAccountCreated = true;
        }
        else if (accountType.equals(AccountType.SAVINGACCOUNT)) {
            account = new SavingAccount(accountType.toString(), clientID, 0, true);
//            accountDAO.createNewAccount(new SavingAccount(accountType, String.format("%03d%06d",1, accountID), clientID, 0, true));
            isAccountCreated = true;
        }
        accountDAO.createNewAccount(account.getAccountType(), account.getClientID(), account.getBalance(), account.isWithdrawAllowed());
        Long lastAccountID = accountDAO.getLastAccountID();
        accountDAO.setFullAccID(String.format("%03d%06d",bankID, lastAccountID), accountDAO.getLastAccountID());
        if(isAccountCreated){
            System.out.println("Bank account created!");
        }
    }

    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
