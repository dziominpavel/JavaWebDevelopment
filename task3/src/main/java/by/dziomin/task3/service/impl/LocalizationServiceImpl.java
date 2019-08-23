package by.dziomin.task3.service.impl;

import by.dziomin.task3.service.LocalizationService;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class LocalizationServiceImpl implements LocalizationService {

    /**
     * instance field.
     */
    private static LocalizationService instance;
    /**
     * logger object.
     */
    private Logger logger = Logger.getLogger(LocalizationServiceImpl.class);
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
        try {
            return rb.getString(key);
        } catch (MissingResourceException e) {
            logger.warn("Message key not found: " + key, e);
            return key;
        } catch (Exception e) {
            logger.error("Localization error", e);
            return key;
        }
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

        if (!newLanguage.isEmpty() && !newCountry.isEmpty()) {
            currentLocale = new Locale(newLanguage, newCountry);
            logger.info(getLocalizedMessage("LOCALIZATION.CHANGED_LOCALE"));
            logger.info(getLocalizedMessage("LOCALIZATION.NEW_LOCALE_IS")
                    + currentLocale);
        }
        return currentLocale;
    }


}
