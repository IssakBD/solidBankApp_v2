package com.example.solidbankapp;

import com.example.solidbankapp.dao.TransactionDAO;
import com.example.solidbankapp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SolidBankApp implements CommandLineRunner{

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... arg0) throws Exception {
        Long clientID = Long.valueOf(1);
        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        TransactionDAO transactionDAO = context.getBean(TransactionDAO.class);


        //Инициализируем ApplicationContext - интерфейс через который будем работать с бинами
//        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
//
        //Достаем через ApplicationContext бин AccountBasicCLI
//        AccountBasicCLI accountBasicCLI = context.getBean("accountBasicCLI", AccountBasicCLI.class);
        //Достаем через ApplicationContext бин AccountBasicCLI
        //MyCLI myCLI = context.getBean("myCLI", MyCLI.class);

        //Записал в переменную сообщение которое нужно каждый раз выводить
        String msg = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transactions\n6 - this message\n7 - exit";
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
                        accountBasicCLI.getAccounts(clientID);
                        break;
                    case "2":
                        System.out.println("Choose account type \n[CHECKING, SAVING, FIXED]");
                        accountBasicCLI.createAccountRequest(clientID);
                        break;
                    case "3":
                        transactionDepositCLI.depositMoney(clientID);
                        break;
                    case "4":
                        transactionWithdrawCLI.withdrawMoney(clientID);
                        break;
                    case "5":
                        System.out.println(transactionDAO.getTransactions());
                        break;
                    case "6":
                        System.out.println(msg);
                        break;
                    default:
                        System.err.println("Wrong input!");
                        System.out.println(msg);
                        break;
                }
            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SolidBankApp.class);
    }

}


//S - single responsibility - каждый класс выполняет свою логику listing class и creation class.
//O - мы можем добавлять новые методы в классах но не будем изменять уже существующий чтобы работающий код не ломался.
//Liskov substitution principle - у кошки eat будет выполнять то же самое что и у dog но не так чтобы он пошел по спать чтобы ожидаемо в коде то что было задумано родителем.
//Interface segregation principle - listging creation interfaces
//Dependency inversion - в инъекции можно передавать родительский интерфейс не меняя тот класс.