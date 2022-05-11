package com.example.solidbankapp;

import com.example.solidbankapp.entity.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SolidBankAppApplication {

    public static void main(String[] args) {

        //Инициализируем ApplicationContext - интерфейс через который будем работать с бинами
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");

        //Достаем через ApplicationContext бин AccountBasicCLI
        AccountBasicCLI accountBasicCLI = context.getBean("accountBasicCLI", AccountBasicCLI.class);
        //Достаем через ApplicationContext бин AccountBasicCLI
        MyCLI myCLI = context.getBean("myCLI", MyCLI.class);

        //Записал в переменную сообщение которое нужно каждый раз выводить
        String msg = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit";
        System.out.println(msg);

        //while(true) loop чтобы каждый раз принимать данные через Scanner
            while(true){
                try {
                    String choice = myCLI.getScanner().nextLine();
                    switch (choice) {
                        case "7":
                            System.out.println("Application closed");
                            System.exit(0);
                            break;
                        case "1":
                            accountBasicCLI.getAccounts("1");
                            break;
                        case "2":
                            System.out.println("Choose account type \n[CHECKING, SAVING, FIXED]");
                            accountBasicCLI.createAccountRequest("1");
                            break;
                        case "3":
                            System.out.println("Not supported yet!");
                            break;
                        case "4":
                            System.out.println("Not supported yet!");
                            break;
                        case "5":
                            System.out.println("Not supported yet!");
                            break;
                        case "6":
                            System.out.println(msg);
                            break;
                        default:
                            System.err.println("Wrong input!");
                            System.out.println(msg);
                    }
                }
                    catch(Exception e){
                            System.err.println(e.getMessage());
                            System.out.println(msg);
                    }
        }
    }
}