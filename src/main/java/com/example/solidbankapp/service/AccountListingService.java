package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;
import com.example.solidbankapp.entity.AccountWithdraw;
import com.example.solidbankapp.exceptions.AccountNotFound;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
public interface AccountListingService {
    public Account getClientAccount(Long clientID, String accountID) throws AccountNotFound;

    public Account getClientAccount(String accountID) throws AccountNotFound;
    public AccountWithdraw getClientWithdrawAccount(Long clientID, String accountID) throws Exception;
    public AccountWithdraw getClientWithdrawAccount(String accountID) throws Exception;
    public List<Account> getClientAccounts(Long clientID);
    public List<Account> getClientAccounts(String username);
    public List<Account> getClientAccountsByType(Long clientID, AccountType accountType);

    public Long getClientIdByUsername(String username);
}
