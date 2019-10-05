package by.dziomin.trade.connection;

import java.io.IOException;
import java.util.Properties;

public class DbConfigManager {

    private static DbConfigManager instance;
    private Properties properties;

    private DbConfigManager() {
        //todo singleton

        init();
    }

    private void init() {
        properties = new Properties();
        try {
            properties.load(DbConfigManager.class.getClassLoader()
                    .getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("READING.PROPERTY_FILE_NOT_FOUND", e);
        }
    }

    public static DbConfigManager getInstance() {
        if (instance == null) {
            instance = new DbConfigManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
