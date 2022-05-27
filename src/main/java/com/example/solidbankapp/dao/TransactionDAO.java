package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Long>{

    @Query("SELECT * FROM TRANSACTIONS")
    List<Transaction> getTransactions();

    @Modifying
    @Query("INSERT INTO TRANSACTIONS (NAME_OF_TRANSACTION, AMOUNT, FULL_ACCOUNT_ID, CLIENT_ID, TRANSACTION_STATUS, DATE) VALUES (:nameOfTransaction, :amount, :fullAccountID, :clientID, :transactionStatus, :date)")
    void addTransactions(String nameOfTransaction, double amount, String fullAccountID, long clientID, boolean transactionStatus, String date);
}
