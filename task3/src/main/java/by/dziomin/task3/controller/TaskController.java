package by.dziomin.task3.controller;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.controller.exception.ControllerException;
import by.dziomin.task3.service.exception.ServiceException;
import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.TextService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;
import by.dziomin.task3.service.impl.TextServiceImpl;

import java.util.Locale;

/**
 * class for handle program requests.
 */
public final class TaskController {
    /**
     * TaskController instance field.
     */
    private static TaskController instance;
    /**
     * TextService instance field.
     */
    private TextService textService;
    /**
     * localizationService instance field.
     */
    private LocalizationService localizationService;

    /**
     * constructor of taskController.
     */
    private TaskController() {
        this.textService = TextServiceImpl.getInstance();
        this.localizationService = LocalizationServiceImpl.getInstance();
    }

    /**
     * get current instance method.
     *
     * @return TaskController instance
     */
    public static TaskController getInstance() {
        if (instance == null) {
            instance = new TaskController();
        }
        return instance;
    }

    /**
     * method of handle program requests.
     *
     * @param requestType type of request
     * @param parameters  parametrs for request
     * @return request
     */
    Object handleRequest(final RequestType requestType,
                         final Object... parameters) {
        try {
            switch (requestType) {
                case CHANGE_LOCALE:
                    return changeLocale(parameters);
                case READ_TEXT_FROM_FILE:
                    return readTextFromFile(parameters);
                case SORT:
                    return sortComponents(parameters);

                case CONCATENATE_TO_STRING:
                    return concatenateText(parameters);
                default:
                    throw new ControllerException("UNSUPPORTED_REQUEST");
            }
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage(), e);
        }
    }

    /**
     * method concatenating text.
     *
     * @param parameters text for concatenating
     * @return String text
     */
    private String concatenateText(final Object[] parameters) {
        if (parameters == null || parameters.length == 0) {
            throw new ControllerException("CONCATENATING_TEXT_NOT_DEFINED");
        }
        Component component = (Component) parameters[0];
        return textService.concatenateText(component);
    }

    /**
     * read text from file controller method.
     *
     * @param parameters file reading parametrs
     * @return Component from text service
     */
    private Component readTextFromFile(final Object[] parameters) {
        String pathParam = null;
        try {
            if (parameters != null && parameters.length > 0) {
                pathParam = parameters[0].toString();
            }
            return textService.readTextFromFile(pathParam);
        } catch (Exception e) {
            throw new ControllerException("READING.READ_FROM_FILE_ERROR", e);
        }
    }

    /**
     * controller method for change locale.
     * @param parameters for change locale service.
     * @return result of localization service.
     */
    private Locale changeLocale(final Object[] parameters) {
        if (parameters == null || parameters.length == 0) {
            throw new ControllerException("LOCALIZATION.LANGUAGE_IS_EMPTY");
        }
        String language = (String) parameters[0];
        if (parameters.length == 1) {
            throw new ControllerException(
                    "LOCALIZATION.LOCALE_COUNTRY_IS_EMPTY");
        }
        String country = (String) parameters[1];
        return localizationService.changeLocale(language, country);
    }

    /**
     * controler method for sorting components.
     * @param parameters for sorting.
     * @return result of sort service method.
     */
    private Component sortComponents(final Object[] parameters) {
        if (parameters == null || parameters.length == 0) {
            throw new ControllerException("SORT.PARAMETER_IS_EMPTY");
        }
        String param = (String) parameters[0];
        if (parameters.length == 1) {
            throw new ControllerException("SORT.TEXT_NOT_DEFINED");
        }
        Component component = (Component) parameters[1];
        if (parameters.length > 2) {
            String compareSymbol = (String) parameters[2];
            return textService.sort(param, component, compareSymbol);
        }
        return textService.sort(param, component);
    }
}
