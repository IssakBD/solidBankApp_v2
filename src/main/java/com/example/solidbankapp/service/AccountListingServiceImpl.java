package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;
import com.example.solidbankapp.entity.AccountWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService{
    private AccountDAO accountDAO;

    @Override
    public Account getClientAccount(Long clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(Long clientID, String accountID) throws Exception {
        if(accountDAO.getClientAccount(clientID, accountID).isWithdrawAllowed()) {
            return accountDAO.getClientWithdrawAccount(clientID, accountID);
        }else {
            throw new Exception("You can't withdraw from fixed account!");
        }
    }

    @Override
    public List<Account> getClientAccounts(Long clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(Long clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }

    @Autowired
    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
