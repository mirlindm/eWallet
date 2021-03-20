package wallet.api.eWallet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wallet.api.eWallet.application.service.eWalletService;
import wallet.api.eWallet.domain.model.eWallet;

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

    // API:
    // GET /user/wallet
    // Create a wallet for the user
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
