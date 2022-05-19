package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    @Autowired
    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID) throws Exception {
        transactionWithdraw.execute(accountListingService.getClientWithdrawAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber()), withdrawDepositOperationCLIUI.requestClientAmount());
    }

}
