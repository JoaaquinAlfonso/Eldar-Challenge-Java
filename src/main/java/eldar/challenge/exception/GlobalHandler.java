package eldar.challenge.exception;

import eldar.challenge.model.dto.response.ResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler({CardException.class})
    public ResponseEntity<ResponseInfo> cardException(CardException cardException, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseInfo(cardException.getMessage(),
                request.getServletPath(),
                HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler({TransactionException.class})
    public ResponseEntity<ResponseInfo> transactionException(TransactionException transactionException, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseInfo(transactionException.getMessage(),
                request.getServletPath(),
                HttpStatus.BAD_REQUEST.value()));
    }
}
