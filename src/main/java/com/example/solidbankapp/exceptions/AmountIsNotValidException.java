package com.example.solidbankapp.exceptions;

public class AmountIsNotValidException extends RuntimeException{
    public AmountIsNotValidException(String message) {
        super(message);
    }
}
