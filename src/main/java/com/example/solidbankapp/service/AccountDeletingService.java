package com.example.solidbankapp.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountDeletingService {
    public void deleteAccount(String fullAccountId);
}
