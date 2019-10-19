package by.dziomin.trade.service;

/**
 * Exception for service layer
 *
 * @author - Pavel Dziomin
 */
public class ServiceException extends Exception {
    /**
     * Constructor
     */
    public ServiceException() {
    }

    /**
     * Constructor
     *
     * @param message message
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message message
     * @param cause   cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor
     *
     * @param cause cause
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }
}
