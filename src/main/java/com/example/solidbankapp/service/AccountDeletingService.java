package com.example.solidbankapp.service;

import com.example.solidbankapp.exceptions.AccountNotFound;
import org.springframework.stereotype.Service;

@Service
public interface AccountDeletingService {
    public void deleteAccount(String fullAccountId) throws AccountNotFound;
}
