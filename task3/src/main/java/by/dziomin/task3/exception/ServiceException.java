package by.dziomin.task3.exception;

/**
 * service exception class.
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(final String message) {
        super(message);
    }

    public ServiceException(final String s, final Exception e) {
    }
}
