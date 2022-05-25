package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO{
    public List<Account> getClientAccounts(String clientID);
    public void createNewAccount(Account account);
    public void updateAccount(Account account, Account newAcc);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    public Account getClientAccount(String clientID, String accountID);
}
