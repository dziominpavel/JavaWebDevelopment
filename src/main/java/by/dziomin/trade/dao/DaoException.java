package by.dziomin.trade.dao;

/**
 * Exception for DAO layer
 *
 * @author - Pavel Dziomin
 */
public class DaoException extends Exception {

    /**
     * Constructor
     */
    public DaoException() {
    }

    /**
     * Constructor
     *
     * @param message message
     */
    public DaoException(final String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message message
     * @param cause   cause
     */
    public DaoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor
     *
     * @param cause cause
     */
    public DaoException(final Throwable cause) {
        super(cause);
    }
}
