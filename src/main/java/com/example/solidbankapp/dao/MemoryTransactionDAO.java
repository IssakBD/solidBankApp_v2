package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryTransactionDAO implements TransactionDAO{
    List<Transaction> transactions;

    public MemoryTransactionDAO() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransactions(Transaction transaction) {
        transactions.add(transaction);
    }
}


