package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransactions(Transaction transaction);
//    @Modifying
//    @Query("INSERT INTO ")
//    public void addTransaction(String nameOfTransaction, double amount, String fullAccountID, int clientID);

}
