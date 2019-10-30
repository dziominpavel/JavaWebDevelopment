package by.dziomin.trade.validator;

import by.dziomin.trade.util.ErrorMessages;

/**
 * Validation exception
 *
 * @author - Pavel Dziomin
 */
public class ValidationException extends Exception {
    public ValidationException() {
    }

    public ValidationException(final String message) {
        super(message);
    }

    public ValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ValidationException(final Throwable cause) {
        super(cause);
    }

    public ValidationException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidationException(final ErrorMessages message) {
        super("ERROR." + message.name());
    }
}
