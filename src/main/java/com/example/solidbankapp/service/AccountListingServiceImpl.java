package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountType;
import com.example.solidbankapp.entity.AccountWithdraw;
import com.example.solidbankapp.entity.UserEntity;
import com.example.solidbankapp.exceptions.AccountNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService{
    private final AccountDAO accountDAO;

    private final UserService userService;

    @Autowired
    public AccountListingServiceImpl(AccountDAO accountDAO, UserService userService) {
        this.accountDAO = accountDAO;
        this.userService = userService;
    }



    @Override
    public Account getClientAccount(Long clientID, String accountID) throws AccountNotFound {
        Account account = accountDAO.getClientAccount(clientID, accountID);
        if(account == null){
            throw new AccountNotFound("Account not found!");
        }
        return account;
    }

    @Override
    public Account getClientAccount(String accountID) throws AccountNotFound {
        Account account = accountDAO.getClientAccount(accountID);
        if(account == null){
            throw new AccountNotFound("Account not found!");
        }
        return account;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(Long clientID, String accountID) throws Exception {
        if(accountDAO.getClientAccount(clientID, accountID) == null){
            throw new AccountNotFound("Account isn't yours!");
        }
        if(accountDAO.getClientAccount(clientID, accountID).isWithdrawAllowed()) {
            return accountDAO.getClientWithdrawAccount(clientID, accountID); //? Он возвращает все строки подходящие по accountID, а как объект вернуть?
        }else {
            throw new Exception("You can't withdraw from fixed account!");
        }
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String accountID) throws Exception {
        if(accountDAO.getClientAccount(accountID).isWithdrawAllowed()) {
            return accountDAO.getClientWithdrawAccount(accountID);
        }else {
            throw new Exception("You can't withdraw from fixed account!");
        }
    }

    @Override
    public List<Account> getClientAccounts(Long clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccounts(String username) {
        Long clientID = userService.getUserByUsername(username).getId().longValue();
        return accountDAO.getClientAccounts(clientID);
    }


    @Override
    public List<Account> getClientAccountsByType(Long clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }

    public List<Account> getClientAccountsByUsername(String username){
        UserEntity user = userService.getUserByUsername(username);
        Long clientId = Long.valueOf(user.getId());
        return accountDAO.getClientAccounts(clientId);
    }

    @Override
    public Long getClientIdByUsername(String username){
        UserEntity user = userService.getUserByUsername(username);
        return Long.valueOf(user.getId());
    }



}
