package com.example.solidbankapp.entity;

import org.springframework.stereotype.Component;

@Component
public interface CreateAccountOperationUI{
    AccountType requestAccountType() throws Exception;
}
