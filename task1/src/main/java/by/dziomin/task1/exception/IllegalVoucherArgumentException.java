package by.dziomin.task1.exception;

public class IllegalVoucherArgumentException extends RuntimeException {
    /**
     * default constructor for IllegalVoucherArgumentException.
     */
    public IllegalVoucherArgumentException() {
    }

    /**
     * constructor for IllegalVoucherArgumentException with parameter message.
     * @param message message for exception.
     */
    public IllegalVoucherArgumentException(final String message) {
        super(message);
    }

    /**
     * constructor for IllegalVoucherArgumentException with parameter message.
     * @param message message for exception.
     * @param cause message for cause.
     */
    public IllegalVoucherArgumentException(final String message,
                                           final Throwable cause) {
        super(message, cause);
    }
}
