package com.example.solidbankapp.controller;

import com.example.solidbankapp.dao.AccountDAO;
import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.entity.*;
import com.example.solidbankapp.exceptions.AccountNotFound;
import com.example.solidbankapp.jwt.JwtProvider;
import com.example.solidbankapp.service.AccountDeletingService;
import com.example.solidbankapp.service.AccountListingService;
import com.example.solidbankapp.service.TransactionListingService;
import com.example.solidbankapp.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private BankCore bankCore;

    @Autowired
    private AccountListingService accountListingService;

    @Autowired
    private AccountDeletingService accountDeletingService;

    @Autowired
    private TransactionDeposit transactionDeposit;

    @Autowired
    private TransactionWithdraw transactionWithdraw;

    @Autowired
    private TransactionListingService transactionListingService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Account> getAllAccounts(Principal principal) {

        String username = principal.getName();
        return accountListingService.getClientAccounts(username);
    }

    @PostMapping()
    public HashMap<String, String> createNewAccount(@RequestParam String accountType, Principal principal) { //principal = username
        bankCore.createNewAccount(AccountType.valueOf(accountType), principal.getName());
        HashMap<String, String> message = new HashMap<>();
        message.put("message : ", "Account was created!");
        return message;
    }

    @GetMapping("/{account_id}")
    public Account getAccountById(@PathVariable String account_id) throws Exception {
        return accountListingService.getClientAccount(1L, account_id);
    }

    @DeleteMapping("/{account_id}")
    public HashMap<String, String> deletingAccount(@PathVariable String account_id) throws AccountNotFound {
        accountDeletingService.deleteAccount(account_id);
        HashMap<String, String> message = new HashMap<>();
        message.put("message : ", "Account was deleted!");
        return message;
    }

    @PostMapping("/{account_id}/withdraw")
    public HashMap<String, String> withdrawFromAccount(@PathVariable String account_id, @RequestParam double amount) throws Exception {
        transactionWithdraw.withdrawFromAccount(account_id, amount);
        HashMap<String, String> message = new HashMap<>();
        message.put("message : ", "Amount: " + amount + " is withdrawed from account: " + account_id);
        return message;
    }

    @PostMapping("/{account_id}/deposit")
    public HashMap<String, String> depositToAccount(@PathVariable String account_id, @RequestParam double amount) throws AccountNotFound {
        transactionDeposit.execute(accountListingService.getClientAccount(1L, account_id), amount);
        HashMap<String, String> message = new HashMap<>();
        message.put("message : ", "Amount: " + amount + " is deposited to account: " + account_id);
        return message;
    }

    @GetMapping("/{account_id}/transactions")
    public List<Transaction> showTransactionsByAccount(@PathVariable String account_id) throws AccountNotFound {
        return transactionListingService.getTransactionsByAccount(account_id);
    }

    @PostMapping("/{account_id}/transfer")
    public HashMap<String, String> transferToAccount(@PathVariable String account_id, @RequestParam String destinationAccountId, @RequestParam double amount, Principal principal) throws Exception {
        Long clientId = accountListingService.getClientIdByUsername(principal.getName());
        AccountWithdraw currentAcc = accountListingService.getClientWithdrawAccount(accountListingService.getClientIdByUsername(principal.getName()), account_id);
        Account destAcc = accountListingService.getClientAccount(destinationAccountId);
        transactionDeposit.execute(currentAcc, destAcc, amount);
        HashMap<String, String> message = new HashMap<>();
        message.put("message : ", "Amount: " + amount + " is deposited to account: " + account_id);
        return message;
    }
}
