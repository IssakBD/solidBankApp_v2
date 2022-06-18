package com.example.solidbankapp.entity;
import com.example.solidbankapp.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
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
        @ResponseBody
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
        String globalExceptionHandler(withdrawAbility ex) {
                return ex.getMessage();
        }
        @ResponseBody
        @ExceptionHandler(UserNotFound.class)
        @ResponseStatus(HttpStatus.OK)
        String userNotFound(UserNotFound ex) {
                return ex.getMessage();
        }
        @ResponseBody
        @ExceptionHandler(AmountIsNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        String amountIsNotValid(AmountIsNotValidException ex) {
                return ex.getMessage();
        }



}
