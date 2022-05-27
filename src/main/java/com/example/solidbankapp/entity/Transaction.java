package com.example.solidbankapp.entity;

import lombok.Data;

@Data
public class Transaction {
    private String transaction_id;
    private String name_of_transaction;
    private double amount;
    private String full_account_id;
    private long client_id;
    private boolean transaction_status;
    private String date;

    public Transaction(String transaction_id, String name_of_transaction, double amount, String full_account_id, int client_id, boolean transaction_status, String date) {
        this.transaction_id = transaction_id;
        this.name_of_transaction = name_of_transaction;
        this.amount = amount;
        this.full_account_id = full_account_id;
        this.client_id = client_id;
        this.transaction_status = transaction_status;
        this.date = date;
    }

    @Override
    public String toString() {
        return "\n" + "Transaction{" +
                "transaction_id='" + transaction_id + '\'' +
                ", name_of_transaction='" + name_of_transaction + '\'' +
                ", amount=" + amount +
                ", full_account_id='" + full_account_id + '\'' +
                ", client_id=" + client_id +
                ", transaction_status=" + transaction_status +
                ", date='" + date + '\'' +
                '}';
    }
}
