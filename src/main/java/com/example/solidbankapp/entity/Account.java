package com.example.solidbankapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Account {
    private String fullAccountID;
    private String accountType;
    private @Id Long id;
    private Long clientID;
    private double balance;
    private boolean withdrawAllowed;

    public Account(String accountType, Long clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

}
