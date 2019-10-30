package by.dziomin.trade.connection;

import by.dziomin.trade.util.ErrorMessages;

/**
 * Connection exception
 *
 * @author - Pavel Dziomin
 */
public class ConnectionException extends RuntimeException {
    public ConnectionException() {
    }

    public ConnectionException(final String message) {
        super(message);
    }

    public ConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(final Throwable cause) {
        super(cause);
    }

    public ConnectionException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Constructor.
     *
     * @param message message
     * @param cause   cause
     */
    public ConnectionException(final ErrorMessages message, final Throwable cause) {
        super("ERROR." + message.name(), cause);
    }

    /**
     * Constructor.
     *
     * @param message message
     */
    ConnectionException(final ErrorMessages message) {
        super("ERROR." + message.name());
    }

}
