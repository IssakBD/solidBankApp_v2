package com.example.solidbankapp.entity;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public double requestClientAmount(){
        System.out.print("Type amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        while(amount <= 0){
            System.out.println("You have to enter the positive number!");
            amount = Double.parseDouble(scanner.nextLine());
        }
        return amount;
    }

    public String requestClientAccountNumber(){
        System.out.print("Type account id: ");
        String accountNumber = scanner.nextLine();
        while(accountNumber.length() != 9){
            System.out.print("Account id's length is not correct! Please write the correct account id: ");
            accountNumber = scanner.nextLine();
        }
        return accountNumber;
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
