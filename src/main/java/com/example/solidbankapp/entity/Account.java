package com.example.solidbankapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Account {
    private String fullAccountID;
    private String accountType;
    private @Id Long accountID;
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

    @Override
    public String toString() {
        return "\n" + "Account{" +
                "fullAccountID='" + fullAccountID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountID=" + accountID +
                ", clientID=" + clientID +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';

    }
}
