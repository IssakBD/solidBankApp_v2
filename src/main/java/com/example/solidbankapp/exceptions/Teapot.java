package com.example.solidbankapp.exceptions;

import java.io.IOException;

public class Teapot extends IOException {
    public Teapot(String message) {
        super(message);
    }
}
