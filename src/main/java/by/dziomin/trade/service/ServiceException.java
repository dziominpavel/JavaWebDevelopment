package by.dziomin.trade.service;

import by.dziomin.trade.util.ErrorMessages;

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

    /**
     * Constructor
     * @param message error message
     */
    public ServiceException(final ErrorMessages message) {
        super("ERROR." + message.name());
    }

    /**
     * Constructor
     *
     * @param message message
     * @param cause   cause
     */
    public ServiceException(final ErrorMessages message, final Throwable cause) {
        super("ERROR." + message.name(), cause);
    }
}
