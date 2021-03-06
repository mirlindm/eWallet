package wallet.api.eWallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class WalletExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<WalletErrorException> handleException(Exception exc) {

        WalletErrorException error = new WalletErrorException();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        error.setResponseStatus(HttpStatus.BAD_REQUEST.value());
        error.setExceptionMessage(exc.getMessage());
        //error.setTimeStamp(localDateFormat.format(new Date()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
