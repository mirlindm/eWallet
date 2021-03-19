package wallet.api.eWallet.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wallet.api.eWallet.domain.model.Transaction;
import wallet.api.eWallet.domain.model.eWallet;
import wallet.api.eWallet.domain.repository.TransactionRepository;
import wallet.api.eWallet.domain.repository.eWalletRepository;

import java.math.BigDecimal;

@Service
public class eWalletService {

    @Autowired
    private eWalletRepository eWalletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public boolean hasWallet() {
        return eWalletRepository.count() > 0;
    }

    public void createWallet(eWallet wallet) {
        eWalletRepository.save(wallet);
    }

    public void createTransaction(Transaction transaction) throws Exception {
        eWallet ewallet = eWalletRepository.findById((long) 1).get();
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
