package by.dziomin.task3.service;

import java.util.Locale;

public interface LocalizationService {

    String getLocalizedMessage(String key);

    Locale changeLocale(String newLanguage, String newCountry);
}
