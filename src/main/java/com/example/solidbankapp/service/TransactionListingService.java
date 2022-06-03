package com.example.solidbankapp.service;

import com.example.solidbankapp.entity.Transaction;
import com.example.solidbankapp.exceptions.AccountNotFound;

import java.util.List;

public interface TransactionListingService {
    public List<Transaction> getTransactionsByAccount(String accountId) throws AccountNotFound;
}
