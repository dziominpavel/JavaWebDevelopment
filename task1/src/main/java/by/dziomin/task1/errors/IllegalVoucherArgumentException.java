package by.dziomin.task1.errors;

public class IllegalVoucherArgumentException extends Exception {
    /**
     * default constructor for IllegalVoucherArgumentException.
     */
    public IllegalVoucherArgumentException() {
    }

    /**
     * constructor for IllegalVoucherArgumentException with parameter message.
     * @param message message for errors.
     */
    public IllegalVoucherArgumentException(final String message) {
        super(message);
    }

    /**
     * constructor for IllegalVoucherArgumentException with parameter message.
     * @param message message for errors.
     * @param cause message for cause.
     */
    public IllegalVoucherArgumentException(final String message,
                                           final Throwable cause) {
        super(message, cause);
    }
}
