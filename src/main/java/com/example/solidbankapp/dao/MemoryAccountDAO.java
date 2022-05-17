package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountDeposit;
import com.example.solidbankapp.entity.AccountType;
import com.example.solidbankapp.entity.AccountWithdraw;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
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
        System.out.println("Bank account created");
    }

    @Override
    public void updateAccount(Account account, Account newAcc) {
        accountList.set(accountList.indexOf(account), newAcc);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountList.stream().filter(x -> x.getClientID() == clientID && x.getAccountType() == accountType)
                .collect(Collectors.toList());
    } //for what?

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        for(Account acc : accountList){
                if (acc.getId().equals(accountID)) {
                    return (AccountWithdraw) acc;
                }
        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for(Account acc : accountList){
            if(acc.getId().equals(accountID)){
                return acc;
            }
        }
        return null;
    }

}
