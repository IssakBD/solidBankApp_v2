package com.example.solidbankapp.entity;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private BankCore bankCore;

    @Autowired
    private TransactionDAO transactionDAO;

    @GetMapping()
    public List<Account> getAllAccounts() {
        return accountDAO.getClientAccounts(1L);
    }

    @PostMapping()
    public String createNewAccount(@RequestParam String accountType){
        bankCore.createNewAccount(AccountType.valueOf(accountType), 1L);
        return "New Bank Account created";
    }

    @GetMapping("/{account_id}")
    public Account getAccountById(@PathVariable String account_id){
        return accountDAO.getClientAccount(1L, account_id);
    }

    @DeleteMapping("/{account_id}")
    public String deletingAccount(@PathVariable String account_id){
        accountDAO.deleteAccount(account_id);
        return "Account is deleted!";
    }

    @PostMapping("/{account_id}/withdraw")
    public String withdrawFromAccount(@PathVariable String account_id, @RequestParam double amount){
        accountDAO.updateBalance(accountDAO.getBalance(account_id) - amount, account_id);
        return "Amount: " + amount + " is withdrawed from account: " + account_id;
    }

    @PostMapping("/{account_id}/deposit")
    public String depositToAccount(@PathVariable String account_id, @RequestParam double amount){
        accountDAO.updateBalance(accountDAO.getBalance(account_id) + amount, account_id);
        return "Amount: " + amount + " is deposited to account: " + account_id;
    }

    @GetMapping("/{account_id}/transactions")
    public List<Transaction> showTransactionsByAccount(@PathVariable String account_id){
        return transactionDAO.getTransactionsByAccountId(account_id);
    }

}
