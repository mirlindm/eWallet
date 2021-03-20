package wallet.api.eWallet.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wallet.api.eWallet.domain.model.Transaction;
import wallet.api.eWallet.domain.model.eWallet;
import wallet.api.eWallet.domain.repository.TransactionRepository;
import wallet.api.eWallet.rest.eWalletRestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Transaction Service
 * involves the methods
 * for the corresponding endpoint purpose
 * for transaction related activities
 * {@link eWalletRestController}
 * {@link TransactionRepository}*
 *
 * @author Mirlind Murati
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * this is the function for fetching
     * specific transaction from the database
     *
     * @param id - {@link Transaction} - id of the Transaction to be fetched
     * @author Mirlind Murati
     */
    public Transaction getTransactionById(Long id) throws Exception {
        Transaction transaction = transactionRepository.findById(id).
                orElseThrow(() ->  new Exception("Transaction Not Found!"));

        return transaction;
    }

    /**
     * this is the function for
     * fetching all transactions
     * from the database
     *
     * @return {@link List<Transaction>}
     * @author Mirlind Murati
     */
    public List<Transaction> getAllTransactions() throws Exception {
        List<Transaction> transactions = transactionRepository.findAll();

        if(transactions.size() == 0) {
            throw new Exception("No transactions exist in the database");
        }

        return transactions;
    }

    /**
     * this is the function for creating a new eWallet
     * from an eWallet request body
     * stores new eWallet in the database
     *
     * @param - {@link eWallet}
     * @author Mirlind Murati
     */
    public Transaction createTransaction(Transaction transaction) throws Exception {
        Transaction transaction1 = new Transaction();

        //eWallet ewallet = eWalletRepository.findById(1L).orElse(null);

        //BigDecimal new_account_balance = ewallet.getBalance().add(transaction.getAmount());

        //if (new_account_balance.doubleValue() < 0) {
//            throw new NegativeAmountException("Withdrawal amount cannot exceed " + wallet.getAccount_balance());
           // throw new Exception("Not enough funds");
        //}


        transaction1.setAmount(transaction.getAmount().abs());
        transaction1.setType(transaction.getType());
        transaction1.setWallet(transaction.getWallet());
        transaction1.setTimestamp(transaction.getTimestamp());
        transactionRepository.save(transaction);

        //ewallet.setBalance(new_account_balance);
        //ewallet.addTransaction(transaction);
        //eWalletRepository.save(ewallet);

        return transaction1;
    }

}
