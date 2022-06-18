package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferServiceImpl implements AccountTransferService{

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AccountListingService accountListingService;

    @Override
    public void transfer(String currentAccountId, String destinationAccountId, double amount) {
        try{
            Account currentAcc = accountListingService.getClientWithdrawAccount(currentAccountId);
            Account destinationAcc = accountListingService.getClientAccount(destinationAccountId);
            if(currentAcc.getBalance() >= amount){
                double currentBalance = currentAcc.getBalance() - amount;
                System.out.println("Amount" + amount);
//                currentAcc.setBalance(currentAcc.getBalance()-amount);
//                accountDAO.save(currentAcc);
                accountDAO.updateBalance(currentBalance, currentAccountId);
                accountDAO.updateBalance(destinationAcc.getBalance() + amount, destinationAccountId);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
