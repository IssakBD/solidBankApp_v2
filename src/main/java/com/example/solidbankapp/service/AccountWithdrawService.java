package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    public void withdraw(double amount, AccountWithdraw account);
}
