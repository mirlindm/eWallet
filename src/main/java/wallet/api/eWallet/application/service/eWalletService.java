package wallet.api.eWallet.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import wallet.api.eWallet.domain.model.Transaction;
import wallet.api.eWallet.domain.model.eWallet;
import wallet.api.eWallet.domain.repository.TransactionRepository;
import wallet.api.eWallet.domain.repository.eWalletRepository;
import wallet.api.eWallet.rest.eWalletRestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * eWallet Service
 * involves the methods
 * for corresponding endpoint purpose
 * {@link eWalletRestController}
 * {@link eWalletRepository}*
 *
 * @author Mirlind Murati
 */
@Service
public class eWalletService {

    @Autowired
    private eWalletRepository eWalletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public boolean isElectronicWalletExisting() {
        return eWalletRepository.count() > 0;

    }

    /**
     * this is the function for fetching
     * specific eWallet from the database
     *
     * @param id - {@link eWallet} - id of the eWallet to be fetched
     * @author Mirlind Murati
     */
    public eWallet getWalletById(Long id) throws Exception {
        eWallet wallet = eWalletRepository.findById(id).
                orElseThrow(() ->  new Exception("Wallet Not Found!"));

        return wallet;
    }

    /**
     * this is the function for
     * fetching all eWallets
     * from the database
     *
     * @return {@link List<eWallet>}
     * @author Mirlind Murati
     */
    public List<eWallet> getAllWallets() throws Exception {
        List<eWallet> wallets = eWalletRepository.findAll();

        if(wallets.size() == 0) {
            throw new Exception("No eWallets exist in the database");
        }

        return wallets;
    }

    /**
     * this is the function for creating a new eWallet
     * from an eWallet request body
     * stores new eWallet in the database
     *
     * @param - {@link eWallet}
     * @author Mirlind Murati
     */
    public eWallet createWallet(eWallet eWallet) throws Exception {
        eWallet newWallet = new eWallet();

        newWallet.setBalance(eWallet.getBalance());

        eWalletRepository.save(newWallet);

        return newWallet;
    }

    public void createTransaction(Transaction transaction) throws Exception {
        eWallet ewallet = eWalletRepository.findById(1L).orElse(null);

        BigDecimal new_account_balance = ewallet.getBalance().add(transaction.getAmount());

        if (new_account_balance.doubleValue() < 0) {
//            throw new NegativeAmountException("Withdrawal amount cannot exceed " + wallet.getAccount_balance());
            throw new Exception("Not enough funds");
        }

        ewallet.setBalance(new_account_balance);
        transaction.setAmount(transaction.getAmount().abs());
        ewallet.addTransaction(transaction);
        transactionRepository.save(transaction);
        eWalletRepository.save(ewallet);
    }




}
