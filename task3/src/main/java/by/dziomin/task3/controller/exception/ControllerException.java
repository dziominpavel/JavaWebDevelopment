package by.dziomin.task3.controller.exception;

import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;

/**
 * controller exception class.
 */
public class ControllerException extends RuntimeException {
    /**
     * localization service instance.
     */
    private final LocalizationService localizationService =
            LocalizationServiceImpl.getInstance();

    public ControllerException() {
    }

    public ControllerException(final Throwable cause) {
        super(cause);
    }

    /**
     * constructor controller exception.
     *
     * @param keyMessage keyMessage
     */
    public ControllerException(final String keyMessage) {
        super(keyMessage);
    }

    /**
     * constructor controller exception.
     *
     * @param keyMessage keyMessage
     * @param cause      cause
     */
    public ControllerException(final String keyMessage, final Throwable cause) {
        super(keyMessage, cause);
    }

    @Override
    public String getLocalizedMessage() {
        return localizationService.getLocalizedMessage(getMessage());
    }
}
