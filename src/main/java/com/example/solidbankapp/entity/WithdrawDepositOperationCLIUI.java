package com.example.solidbankapp.entity;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();
    String requestClientAccountNumber();
}
