package by.dziomin.task3.service;

import by.dziomin.task3.exception.ServiceException;
import by.dziomin.task3.service.impl.LocalizationServiceImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DataReader.
 */
public final class DataReader {

    /**
     * DataReader.
     */
    private static DataReader instance;

    /**
     * default constructor.
     */
    private DataReader() {
        //default constructor.
    }

    /**
     * getInstance DataReader.
     *
     * @return instance.
     */
    public static DataReader getInstance() {

        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    /**
     * method for reading data from file.
     *
     */
    public String readFile() {

        Properties properties = new Properties();
        System.out.println("123");
        try {
            properties.load(DataReader.class.getClassLoader().getResourceAsStream(
                    "app.properties"));
        } catch (IOException e) {
            throw new ServiceException("READING.PROPERTY_FILE_NOT_FOUND", e);
        }


        Path path = Paths.get(properties.getProperty("DEFAULT_TEXT_FILE_PATH"));
        Logger logger = Logger.getLogger(DataReader.class);
        String message = LocalizationServiceImpl.getInstance()
                .getLocalizedMessage("READING.READING_FILE_FROM_FILE");
        logger.debug(message);

        try (Stream<String> stream = Files.lines(path)) {
            message = LocalizationServiceImpl.getInstance()
                    .getLocalizedMessage("READING.READING_SUCCESSFUL");
            logger.debug(message);
            return stream.collect(Collectors.joining());
        } catch (IOException e) {
            throw new ServiceException("READING.FILE_NOT_FOUND", e);
        }
    }
}


