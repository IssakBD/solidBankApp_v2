package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.Account;
import com.example.solidbankapp.entity.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    public void deposit(double amount, Account account);
}
