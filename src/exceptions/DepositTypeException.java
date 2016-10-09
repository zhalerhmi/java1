package exceptions;

/**
 * Created by DOTIN SCHOOL 4 on 9/6/2016.
 */
public class DepositTypeException extends RuntimeException {
    public DepositTypeException() {
        super();
    }

    public DepositTypeException(String message) {
        super(message);
    }

    public DepositTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
