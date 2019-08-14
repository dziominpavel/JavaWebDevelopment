package by.dziomin.task3.exception;

import java.io.FileNotFoundException;

/**
 * service exception class.
 */
public class ServiceException extends Throwable {
    public ServiceException(final String s, final FileNotFoundException e) {
    }
}
