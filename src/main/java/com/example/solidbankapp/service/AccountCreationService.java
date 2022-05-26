package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    public void create(AccountType accountType, long bankID, Long clientID);
}
