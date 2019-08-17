package by.dziomin.task3.service.impl;

import by.dziomin.task3.service.LocalizationService;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public final class LocalizationServiceImpl implements LocalizationService {
    /**
     * instance field.
     */
    private static LocalizationService instance;
    /**
     * currentlocale field.
     */
    private Locale currentLocale;

    private LocalizationServiceImpl() {
        this.currentLocale = Locale.getDefault();
    }

    /**
     * getincstance method.
     *
     * @return LocalizationService instance
     */
    public static LocalizationService getInstance() {
        if (instance == null) {
            instance = new LocalizationServiceImpl();
        }
        return instance;
    }

    @Override
    public String getLocalizedMessage(final String key) {
        ResourceBundle rb = ResourceBundle.getBundle("text", currentLocale);
        return rb.getString(key);
    }

    /**
     * changeLocale service method.
     *
     * @param newLanguage newLanguage
     * @param newCountry  newCountry
     * @return Locale newLocale
     */
    @Override
    public Locale changeLocale(final String newLanguage,
                               final String newCountry) {
        Locale locale = new Locale(newLanguage, newCountry);
        this.currentLocale = locale;
        Logger logger = Logger.getLogger(LocalizationServiceImpl.class);
        logger.info(getLocalizedMessage("CHANGED_LOCALE"));
        logger.info(getLocalizedMessage("NEW_LOCALE_IS") + currentLocale);
        return locale;
    }


}
