package by.dziomin.task3.exception;

import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;
import org.apache.log4j.Logger;

/**
 * service exception class.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(final String keyMessage) {
        LocalizationService localizationService =
                LocalizationServiceImpl.getInstance();
        Logger logger = Logger.getLogger(ServiceException.class);
        logger.error(localizationService.getLocalizedMessage(keyMessage));
    }

    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
