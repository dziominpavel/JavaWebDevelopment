package by.dziomin.task2.service;


import by.dziomin.task2.exception.MatrixException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.SEPARATOR;

/**
 * DataParcer.
 */
public final class DataParcer {

    /**
     * DataParcer.
     */
    private static DataParcer instance;

    /**
     * default constructor.
     */
    private DataParcer() {
    }

    /**
     * getInstance DataParcer.
     *
     * @return instance.
     */
    public static DataParcer getInstance() {

        if (instance == null) {
            instance = new DataParcer();
        }
        return instance;
    }

    /**
     * matrixInfo.
     *
     * @param stringInfo stringInfo.
     * @return matrixInfo.
     * @throws MatrixException MatrixException.
     */
    public List<String[]> matrixInfo(final List<String> stringInfo)
            throws MatrixException {
        Logger logger = Logger.getLogger(DataParcer.class);
        logger.info("parcing matrix data...");
        if (stringInfo.isEmpty()) {
            throw new MatrixException("Error of parcing matrix file");
        }
        List<String[]> matrixInfo = new ArrayList<>();
        for (String row : stringInfo) {

            matrixInfo.add(row.split(SEPARATOR));
        }
        logger.info("parcing matrix data success");
        return matrixInfo;
    }

    /**
     * threadInfo.
     *
     * @param stringInfo stringInfo.
     * @return String[] threadInfo.
     * @throws MatrixException MatrixException.
     */
    public String[] threadInfo(final List<String> stringInfo)
            throws MatrixException {
        Logger logger = Logger.getLogger(DataParcer.class);
        logger.info("parcing thread data...");
        if (stringInfo.isEmpty() || stringInfo.size() != 1) {
            throw new MatrixException("Error of parcing thread file");
        }
        logger.info("parcing thread data success");
        return stringInfo.get(0).split(SEPARATOR);
    }


}
