package com.example.solidbankapp.entity;

import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public double requestClientAmount(){
        return 0;
    };
    public String requestClientAccountNumber(){
        return null;
    };
    public AccountType requestAccountType() throws Exception {
        switch (scanner.nextLine()){
            case "FIXED":
                return AccountType.FIXEDACCOUNT;
            case "SAVING":
                return AccountType.SAVINGACCOUNT;
            case "CHECKING":
                return AccountType.CHECKINGACCOUNT;
            default:
                throw new Exception("Wrong type of account!");
        }
    };
}
