package exceptions;

/**
 * Created by DOTIN SCHOOL 4 on 9/6/2016.
 */
public class DepositBalanceException extends RuntimeException {
    public DepositBalanceException() {
        super();
    }

    public DepositBalanceException(String message) {
        super(message);
    }

    public DepositBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
