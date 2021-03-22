Digital Wallet Application created with Spring Boot (Rest API) for the Backend and React.js for the Frontend side.

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
