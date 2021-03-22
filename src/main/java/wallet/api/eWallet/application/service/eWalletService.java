package wallet.api.eWallet.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import wallet.api.eWallet.domain.model.Transaction;
import wallet.api.eWallet.domain.model.eWallet;
import wallet.api.eWallet.domain.repository.TransactionRepository;
import wallet.api.eWallet.domain.repository.eWalletRepository;
import wallet.api.eWallet.exception.WalletAlreadyExistingException;
import wallet.api.eWallet.exception.WalletNotFoundException;
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
 * for eWallet related activities
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
                orElseThrow(() ->  new WalletNotFoundException("eWallet Not Found!"));

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
            throw new WalletNotFoundException("No eWallets exist in the database");
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
    public eWallet createWallet() throws Exception {
        eWallet newWallet = new eWallet();

        newWallet.setBalance(new BigDecimal("0.0"));
        eWalletRepository.save(newWallet);

        return newWallet;
    }

    /**
     * this is the function for
     * updating specific eWallet balance
     * updates and stores new eWallet in the database
     *
     *
     * @param - {@link eWallet}
     * @author Mirlind Murati
     */
    public eWallet updateWallet(eWallet eWallet) {
        eWallet newWallet = eWalletRepository.findById(eWallet.getId())
                .orElseThrow(null);

        newWallet.setBalance(eWallet.getBalance());

        eWalletRepository.save(newWallet);
        return newWallet;
    }

    /**
     * this is the function for deleting
     * a specific eWallet from the database
     *
     * @param id - {@link eWallet} - id of the eWallet to be deleted
     * @return {@link eWallet} - the deleted eWallet
     * @author Mirlind Murati
     */
    public eWallet deleteWallet(Long id) throws Exception {
        eWallet eWallet = eWalletRepository.findById(id)
                .orElseThrow(null);
        //() -> new ResourceNotFoundException("\n No Vendor found with id : " + id)

        eWalletRepository.deleteById(eWallet.getId());
        return eWallet;
    }






}
