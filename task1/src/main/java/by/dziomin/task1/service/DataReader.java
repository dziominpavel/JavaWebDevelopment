package by.dziomin.task1.service;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public final class DataReader {

    /**
     * default constructor.
     */
    private DataReader() {
        //default constructor.
    }

    /**
     * class for reading data from file.
     *
     * @param file file.
     * @return stringList. List with data.
     */

    public static List<String> dataReader(final File file) {
        List<String> stringList = new ArrayList<>();
        Logger logger = Logger.getLogger(DataReader.class);
        logger.info("reading data from file...");
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(file))) {
            String dataLine;
            while ((dataLine = bufferedReader.readLine()) != null) {
                stringList.add(dataLine);
            }
            logger.info("reading data success.");
            logger.info(stringList.size() + " lines read from file.");
        } catch (Exception e) {
            logger.error("Error of reading data from file");
        }
        return stringList;
    }
}


