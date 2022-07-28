package eldar.challenge.exception;

public class TransactionException extends RuntimeException{

    private static final long serialVersionUID = 1852223100836937340L;

    public TransactionException(String message) {
        super(message);
    }
}
