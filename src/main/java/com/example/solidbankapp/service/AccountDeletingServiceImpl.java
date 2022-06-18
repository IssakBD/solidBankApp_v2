package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.exceptions.AccountNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDeletingServiceImpl implements AccountDeletingService{
    @Autowired
    private AccountListingService accountListingService;
    @Autowired
    private AccountDAO accountDAO;
    @Override
    public void deleteAccount(String fullAccountId) throws AccountNotFound {
        Account account = accountListingService.getClientAccount(1L, fullAccountId);
        accountDAO.deleteAccount(fullAccountId);
    }


}
