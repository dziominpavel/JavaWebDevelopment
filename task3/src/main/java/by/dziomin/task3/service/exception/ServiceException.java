package by.dziomin.task3.service.exception;

import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;

/**
 * service exception class.
 */
public class ServiceException extends RuntimeException {
    /**
     * localization service instance.
     */
    private final LocalizationService localizationService =
            LocalizationServiceImpl.getInstance();

    /**
     * constructor service exception.
     *
     * @param keyMessage keyMessage
     */
    public ServiceException(final String keyMessage) {
        super(keyMessage);
    }

    /**
     * constructor service exception.
     *
     * @param keyMessage keyMessage
     * @param cause      cause
     */
    public ServiceException(final String keyMessage, final Throwable cause) {
        super(keyMessage, cause);
    }

    @Override
    public String getLocalizedMessage() {
        return localizationService.getLocalizedMessage(getMessage());
    }
}
