package wallet.api.eWallet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wallet.api.eWallet.application.service.eWalletService;
import wallet.api.eWallet.domain.model.eWallet;

import java.util.List;
import java.util.Map;

/**
 * Rest Endpoints controller
 * Utilizes {@link eWalletService }
 *
 * @author Mirlind Murati
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/eWallet")
public class eWalletRestController {

    @Autowired
    private eWalletService eWalletService;

    /**
     * end-point method for getting a eWallet by the ID
     *
     * @param id - ID of the eWallet to be fetched
     * @return eWallet
     * @author Mirlind Murati
     */
    @GetMapping("/{id}")
    public ResponseEntity<eWallet> getWalletById(@PathVariable("id") Long id) throws Exception {
        eWallet wallet = eWalletService.getWalletById(id);

        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

    /**
     * end-point method for fetching all wallets
     *
     * @return CollectionModel<eWallet>
     * @author Mirlind Murati
     */
    @GetMapping("/")
    public ResponseEntity<List<eWallet>> getAllWallets() throws Exception {
        List<eWallet> wallets = eWalletService.getAllWallets();

        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }

    /**
     * end-point method for creating a new wallet
     *
     * @return eWallet
     * @author Mirlind Murati
     */
    @PostMapping("/wallets")
    public ResponseEntity<eWallet> createWallet(@RequestBody eWallet wallet) throws Exception {
        eWallet newWallet = eWalletService.createWallet(wallet);

        return new ResponseEntity<>(newWallet, HttpStatus.CREATED);

//        if (eWalletService.isElectronicWalletExisting()) {
//            //throw new HasWalletException("User already has a wallet");
//            throw new Exception("Electronic Wallet Exists!");
//        }
//        else {
//            eWallet newWallet = new eWallet();
//            eWalletService.createNewElectronicWallet(newWallet);
//
//            return newWallet;
        //}
    }


}
