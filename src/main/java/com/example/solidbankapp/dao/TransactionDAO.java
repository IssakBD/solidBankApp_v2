package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO {
    List<Transaction> getTransactions();
    public void addTransaction(Transaction transaction);
}
