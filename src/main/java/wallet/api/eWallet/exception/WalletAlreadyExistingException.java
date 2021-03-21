package wallet.api.eWallet.exception;

public class WalletAlreadyExistingException extends RuntimeException {
    public WalletAlreadyExistingException(String message) {
        super(message);
    }
}
