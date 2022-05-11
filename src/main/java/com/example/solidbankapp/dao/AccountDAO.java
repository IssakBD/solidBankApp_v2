package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.*;

import java.util.List;

public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);
    public void createNewAccount(Account account);
    public void updateAccount(Account account);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    public Account getClientAccount(String clientID, String accountID);
}
