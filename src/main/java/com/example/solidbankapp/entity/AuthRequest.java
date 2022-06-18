package com.example.solidbankapp.entity;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}