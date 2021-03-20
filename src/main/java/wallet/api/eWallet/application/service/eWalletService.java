package wallet.api.eWallet.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wallet.api.eWallet.domain.model.Transaction;
import wallet.api.eWallet.domain.model.eWallet;
import wallet.api.eWallet.domain.repository.TransactionRepository;
import wallet.api.eWallet.domain.repository.eWalletRepository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class eWalletService {

    @Autowired
    private eWalletRepository eWalletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public boolean isElectronicWalletExisting() {
        return eWalletRepository.count() > 0;
    }

//    public eWallet createWallet(eWallet wallet) {
//        eWalletRepository.save(wallet);
//    }

    public eWallet createWallet(eWallet eWallet) throws Exception {
        eWallet wallet = new eWallet();

        wallet.setBalance(eWallet.getBalance());

        eWalletRepository.save(wallet);

        return wallet;
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
