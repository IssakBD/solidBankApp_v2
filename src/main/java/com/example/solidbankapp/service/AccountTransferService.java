package com.example.solidbankapp.service;

public interface AccountTransferService {
    public void transfer(String currentAccountId, String destinationAccountId, double amount);
}
