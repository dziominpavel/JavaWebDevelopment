package by.dziomin.task3.service.impl;

import by.dziomin.task3.service.LocalizationService;

import java.util.Locale;

public class LocalizationServiceImpl implements LocalizationService {
    private static LocalizationService instance;
    private Locale currentLocale;

    private LocalizationServiceImpl() {
        this.currentLocale = Locale.getDefault();
    }

    public static LocalizationService getInstance(){
        if (instance == null) {
            instance = new LocalizationServiceImpl();
        }
        return instance;
    }

    @Override
    public String getLocalizedMessage(final String key) {
        return key; //todo
    }

    @Override
    public Locale changeLocale(final String newLanguage,
                             final String newCountry) {
        Locale locale = new Locale(newLanguage, newCountry);
        this.currentLocale = locale;
        return locale;
    }


}
