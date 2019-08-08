package by.dziomin.task2.service;

import by.dziomin.task2.exception.MatrixException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
     * class for reading data from file.
     *
     * @param path path.
     * @return stringList. List with data.
     * @throws MatrixException MatrixException.
     */
    public List<String> readFile(final Path path) throws MatrixException {
        List<String> stringList = new ArrayList<>();
        Logger logger = Logger.getLogger(DataReader.class);
        logger.info("reading data from file...");

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(stringList::add);
            logger.info("reading data success.");
            logger.info(stringList.size() + " lines readed");
        } catch (IOException e) {
            throw new MatrixException("Error of reading data from file",
                    new FileNotFoundException());
        }
        return stringList;
    }
}


