package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDeletingServiceImpl implements AccountDeletingService{
    @Autowired
    private AccountDAO accountDAO;
    @Override
    public void deleteAccount(String fullAccountId) {
        accountDAO.deleteAccount(fullAccountId);
    }
}
