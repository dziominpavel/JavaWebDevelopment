package by.dziomin.task3.service;

import java.util.Locale;

/**
 * localization service interface.
 */
public interface LocalizationService {
    /**
     * get localized message.
     *
     * @param key of localized message.
     * @return localized message.
     */
    String getLocalizedMessage(String key);

    /**
     * method set new locale.
     *
     * @param newLanguage newLanguage
     * @param newCountry  newCountry
     * @return new Locale.
     */
    Locale changeLocale(String newLanguage, String newCountry);
}
