package com.example.solidbankapp.entity;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.exceptions.AmountIsNotValidException;
import com.example.solidbankapp.service.AccountDepositService;
import com.example.solidbankapp.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class TransactionDeposit {
    private final AccountDepositService accountDepositService;
    private final AccountWithdrawService accountWithdrawService;
    private final TransactionDAO transactionDAO;

    public void execute(Account account, double amount){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        accountDepositService.deposit(account, amount);
        transactionDAO.addTransactions("Deposit", amount, account.getFullAccountID(), account.getClientID(),true, dtf.format(now));
    }
    public void execute(AccountWithdraw currentAccount, Account destinationAccount, double amount){
        if (amount < 0){
            throw new AmountIsNotValidException("Amount is not valid!");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        accountWithdrawService.withdraw(amount, currentAccount);
        accountDepositService.deposit(destinationAccount, amount);
        transactionDAO.addTransactions("Deposit", amount, currentAccount.getFullAccountID(), currentAccount.getClientID(),true, dtf.format(now));
    }
}
