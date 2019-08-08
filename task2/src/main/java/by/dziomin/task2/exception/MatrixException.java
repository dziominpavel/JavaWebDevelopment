package by.dziomin.task2.exception;

import org.apache.log4j.Logger;

/**
 * Exception of matrix exception.
 */
public class MatrixException extends Exception {
    /**
     * matrix exception.
     *
     * @param message message
     */
    public MatrixException(final String message) {
        Logger logger = Logger.getLogger(MatrixException.class);
        logger.error(message);
    }

    /**
     * matrix exception.
     *
     * @param message message
     * @param cause   cause
     */
    public MatrixException(final String message, final Throwable cause) {
        Logger logger = Logger.getLogger(MatrixException.class);
        logger.error(message, cause);
    }

}
