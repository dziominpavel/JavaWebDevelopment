package by.dziomin.task3.controller;

import by.dziomin.task3.exception.ServiceException;
import by.dziomin.task3.pojo.Component;
import by.dziomin.task3.service.LocalizationService;
import by.dziomin.task3.service.TextService;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;
import by.dziomin.task3.service.impl.TextServiceImpl;

import java.util.Locale;


public class TaskController {
    private static TaskController instance;
    private TextService textService;
    private LocalizationService localizationService;

    private TaskController() {
        this.textService = TextServiceImpl.getInstance();
        this.localizationService = LocalizationServiceImpl.getInstance();
    }

    public static TaskController getInstance(){
        if (instance == null) {
            instance = new TaskController();
        }
        return instance;
    }

    public Object handleRequest(RequestType requestType, Object... parameters) {
        switch (requestType) {
            case CHANGE_LOCALE -> {
                return changeLocale(parameters);
            }
            case READ_TEXT_FROM_FILE -> {
                return readTextFromFile(parameters);
            }
            case SORT -> {
                return sortComponents(parameters);
            }
            case CONCATENATE_TO_STRING -> {
                return concatenateText(parameters);
            }
            default -> throw new ServiceException("UNSUPPORTED_REQUEST");
        }
    }

    private String concatenateText(final Object[] newParameters) {
        if (newParameters == null || newParameters.length == 0) {
            throw new ServiceException("CONCATENATING_TEXT_NOT_DEFINED");
        }
        Component component = (Component) newParameters[0];
        return textService.concatenateText(component);
    }

    private Component readTextFromFile(final Object[] newParameters) {
        String pathParam = null;
        if (newParameters != null && newParameters.length > 0) {
            pathParam = (String) newParameters[0];
        }
        return textService.readTextFromFile(pathParam);
    }

    private Locale changeLocale(final Object[] newParameters) {
        if (newParameters == null || newParameters.length == 0) {
            throw new ServiceException("LANGUAGE_IS_EMPTY");
        }
        String language = (String) newParameters[0];
        if (newParameters.length == 1) {
            throw new ServiceException("LOCALE_COUNTRY_IS_EMPTY");
        }
        String country = (String) newParameters[1];
        return localizationService.changeLocale(language, country);
    }

    private Component sortComponents(final Object[] newParameters) {
        if (newParameters == null || newParameters.length == 0) {
            throw new ServiceException("SORT_PARAMETER_IS_EMPTY");
        }
        String param = (String) newParameters[0];
        if (newParameters.length == 1) {
            throw new ServiceException("SORTING_TEXT_NOT_DEFINED");
        }
        Component component = (Component) newParameters[1];
        if (newParameters.length > 2) {
            String compareSymbol = (String) newParameters[2];
            return textService.sort(param, component, compareSymbol);
        }
        return textService.sort(param, component);
    }
}
