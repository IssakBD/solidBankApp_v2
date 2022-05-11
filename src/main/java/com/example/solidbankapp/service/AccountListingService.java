package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;
import com.example.solidbankapp.entity.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    public List<Account> getClientAccounts(String clientID);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
