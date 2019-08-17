package by.dziomin.task3.logic;

import by.dziomin.task3.exception.ServiceException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
     * @param path path.
     * @return stringList. List with data.
     * @throws ServiceException ServiceException.
     */
    public String readFile(final Path path) throws ServiceException {
        Logger logger = Logger.getLogger(DataReader.class);
        logger.debug("Reading data from file...");

        try (Stream<String> stream = Files.lines(path)) {
            logger.debug("Reading Succesful");
            return stream.collect(Collectors.joining());
        } catch (IOException e) {
            throw new ServiceException("Error of reading data from file",
                    new FileNotFoundException());
        }
    }
}


