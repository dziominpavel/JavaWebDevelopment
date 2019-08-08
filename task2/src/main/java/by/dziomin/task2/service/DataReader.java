package by.dziomin.task2.service;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
     * class for reading data from file.
     *
     * @param path path.
     * @return stringList. List with data.
     */

    public List<String> readFile(final Path path) {
        List<String> stringList = new ArrayList<>();
        Logger logger = Logger.getLogger(DataReader.class);
        logger.info("reading data from file...");

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(stringList::add);
            logger.info("reading data success.");
            logger.info(stringList.size() + " lines readed");
        } catch (IOException newE) {
            logger.error("Error of reading data from file");
            newE.printStackTrace();
        }
        return stringList;
    }
}


