package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.*;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO extends CrudRepository<Account, Long>{
    @Query("SELECT * FROM ACCOUNT WHERE CLIENT_ID = :clientID")
    public List<Account> getClientAccounts(Long clientID);

    @Modifying
    @Query("INSERT INTO ACCOUNT (ACCOUNT_TYPE, CLIENT_ID, BALANCE, WITHDRAW_ALLOWED) VALUES (:accountType, :clientID, :balance, :withdrawAllowed)")
    public void createNewAccount(String accountType, Long clientID, double balance, boolean withdrawAllowed);

    @Query("SELECT MAX(ACCOUNT_ID) FROM ACCOUNT")
    public Long getLastAccountID();

    @Modifying
    @Query("UPDATE ACCOUNT SET FULL_ACCOUNT_ID = :accountFullID WHERE ACCOUNT_ID = :accountID")
    public void setFullAccID(String accountFullID, Long accountID);

//  public void createNewAccount(Account account);

    @Modifying
    @Query("UPDATE ACCOUNT SET BALANCE = :balance WHERE FULL_ACCOUNT_ID = :fullAccountID")
    public void updateBalance(double balance, String fullAccountID);

    @Query("SELECT BALANCE FROM ACCOUNT WHERE FULL_ACCOUNT_ID = :fullAccountID")
    public double getBalance(String fullAccountID);

    @Query("SELECT * FROM ACCOUNT WHERE ACCOUNT_TYPE = :accoutType")
    public List<Account> getClientAccountsByType(Long clientID, AccountType accountType);

    @Query("SELECT * FROM ACCOUNT WHERE FULL_ACCOUNT_ID = :fullAccountID")
    public AccountWithdraw getClientWithdrawAccount(Long clientID, String fullAccountID);

    @Query("SELECT * FROM ACCOUNT WHERE FULL_ACCOUNT_ID = :accountID")
    public Account getClientAccount(Long clientID, String accountID);

}
