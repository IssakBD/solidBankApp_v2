package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.entity.Transaction;
import com.example.solidbankapp.entity.TransactionDeposit;
import com.example.solidbankapp.exceptions.AccountNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
public class TransactionListingServiceImpl implements TransactionListingService{
    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionListingServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public List<Transaction> getTransactionsByAccount(String accountId) throws AccountNotFound {
        List<Transaction> transactions = transactionDAO.getTransactionsByAccountId(accountId);
        if(transactions.isEmpty()){
            throw new AccountNotFound("Account not found, hence there is no one transactions!");
        }
        return transactions;
    }
}
