# Digital Wallet Application created with Spring Boot (Rest API) for the Backend and React.js for the Frontend side.

The frontend Repo can be found here: https://github.com/mirlindm/eWalletFrontend

Technologies used for the backend: Java, Spring Boot, Maven, Hibernate, H2 DB, Mockito, jUnit.

This backend e-Wallet application exhibits a REST API, as follows:

URI                       | HTTP Verb     | Description
------------------------- | ------------- | ------------- 
/eWallet/{id}             | GET           | Retrieves a single e-wallet based on its ID
/eWallet/                 | GET           | Retrieves a list of all e-wallets
/eWallet/wallets          | POST          | Creates a new e-wallet
/eWallet/{id}             | DELETE        | Deletes an e-wallet from the database based on its id
/eWallet/transaction/{id} | GET           | Retrieves a Transaction details based on its ID
/eWallet/transcations     | GET           | Retrieves a list of all transactions
/eWallet/transactions     | POST          | Creates a new transaction
/eWallet/transactions     | PUT           | Updates an existing transaction based on its request body




# How to Run the Backend App
1. Clone this repository via: git clone https://github.com/mirlindm/eWallet.git

2. Run mvn clean package on the command line to download all the maven dependencies.

3. Open and Run the Application using IntelliJ or your preferred IDE.

4. The application will run on localhost:8080 on the browser. 
4.1. You can change the port number in /src/main/resources/application.properties, where you can modify the server.port property as per your needs.


# Exceptions
There are several custom exceptions implemented for this backend application, in the exception package in src/main/java/wallet/api/eWallet/exception:

1. InvalidAmountException
2. TransactionNotFoundException
3. WalletAlreadyExistingException
4. WalletErrorException
5. WalletExceptionHandler
6. WalletNotFoundException
