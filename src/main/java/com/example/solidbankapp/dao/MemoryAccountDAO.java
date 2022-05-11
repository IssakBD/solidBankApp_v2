package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;
import com.example.solidbankapp.entity.AccountWithdraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountList.stream().filter(x -> x.getClientID() == clientID)
                .collect(Collectors.toList());
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return null;
    }

}
