package com.example.solidbankapp.entity;
import com.example.solidbankapp.exceptions.AccountNotFound;
import com.example.solidbankapp.exceptions.withdrawAbility;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class AccountNotFoundAdvice {
        @ResponseBody
        @ExceptionHandler(AccountNotFound.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String accountNotFound(AccountNotFound ex) {
            return ex.getMessage();
        }
        @ResponseBody
        @ExceptionHandler(withdrawAbility.class)
        @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
        String withdrawAbility(withdrawAbility ex) {
            return ex.getMessage();
        }



}
