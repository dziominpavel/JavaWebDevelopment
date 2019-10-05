package by.dziomin.trade.connection;

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
}
