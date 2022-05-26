package com.example.solidbankapp.entity;

import com.example.solidbankapp.service.AccountListingService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    //depositMoney() ведет вызывает execute() который в себе вызывает deposit().
    //execute(Account account, double amount), чтобы достать аккаунт обращаемся в базу через accountListingService, и через withdrawDepositOperationCLIUI вызываем сканнер в который запрашиваем с терминала данные.
    public void depositMoney(Long clientID){
        transactionDeposit.execute(accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber()), withdrawDepositOperationCLIUI.requestClientAmount());
    }
}
