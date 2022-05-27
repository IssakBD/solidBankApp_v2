# Solid Bank Application

#### Какие навыки вы приобретете, выполнив данный проект:
* Работа с СУБД h2;
* Использование JDBC;
* Работа с миграциями flywaydb;

### Описание:
Вы реализовали рабочую программу с бизнес логикой по работе с банковскими операции. Команда разработки просит вас добавить взаимодействия с базой данных.

В данном проекте Вам необходимо реализовать ```AccountDAO``` и ```TransactionDAO``` с использованием базы данных.

Архитектор проекта отправил вам новое сообщение:

Привет! Ты уже очень близок к завершению. Следующее сообщение будет от меня последним.

На прошлом проекте ты работал с SQL. В реальной работе, операции с базами данных является одним из ключевых моментов в разработке. Любой программе, особенно веб-приложению, необходимо хранить данные в удобном формате.

Но в процессе планирования проекта, не заостряй внимание на выборе типа базы данных. Выбор базы данных должен быть после обсуждения всех бизнес процессов.

![applicationStructure](https://ucarecdn.com/ab40e4af-5ca4-4531-99be-cda03c52c738/)

Данный график описывает структуру проекта, который подходит под описание чистой архитектуры. DB находится отдельно и его методы вызываются через Gateway из Use Cases.

В нашем примере UseCase - это сервисы AccountDepositService, AccountListingService и другие.

Gateway в данном примере это интерфейс AccountDAO и TransactionDAO.

В прошлых проектах мы использовали реализацию AccountDAO в памяти: MemoryAccountDAO. Теперь нам необходимо использовать БД.

В этот раз ты можешь изменять структуру проекта по своему усмотрению. Ты можешь удалить все методы внутри интерфейса AccountDAO и вместо это наследовать его от CrudRepository.

Там где это возможно, используй lombok. Так код станет более читабельным, скрывая очевидные операции.

С наилучшими пожеланиями, Джон Доу

### Основные задачи:
Подключить Spring Boot JDBC.
Добавить миграции по созданию таблиц для Account и Transaction.
Привязать Java классы Account, Transaction к таблицам.
Создать методы CRUD для Account, Transaction.
Конечная программа должна выполнять традиционные банковские операции.

К основным операциям, выполняемым пользователем со счетами в данной версии относятся:

Получение информации о всех счетах
Создание счета
Пополнение счета (debit)
Снятие денег со счета (withdraw)

### Пример работы:
![Example of code working](https://ucarecdn.com/4f99674b-c562-48ce-8c76-6752d8624bcf/)

### Пример точки входа программы:
```java
package com.example.demo;

import com.example.demo.delivery.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		boolean running = true;
		String clientID = "1";

		MyCLI myCLI = context.getBean(MyCLI.class);
		AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
		TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
		TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);

		String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
        System.out.printf("Welcome to CLI bank service\n");
        System.out.printf("Enter operation number: \n");
        System.out.printf(helpMessage);
        while(running){
            switch(myCLI.getScanner().nextLine()){

                case "1":
                    accountBasicCLI.getAccounts(clientID);
                    break;

                case "2":
                    accountBasicCLI.createAccountRequest(clientID);
                    break;

                case "3":
                    transactionDepositCLI.depositMoney(clientID);
                    break;

                case "4":
                    transactionWithdrawCLI.withdrawMoney(clientID);
                    break;

                case "6":
                    System.out.printf(helpMessage);
                    break;

                case "7":
                    System.out.printf("Application Closed\n");
                    running = false;
                    break;

                default:
                    System.out.printf("Command not recognized!\n");
                    break;
            }
        }
        myCLI.getScanner().close();
	}
}
```
### How to run:
```
java -jar solidBankApp-0.0.1-SNAPSHOT.jar
```
