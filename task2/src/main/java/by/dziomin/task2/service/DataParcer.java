package by.dziomin.task2.service;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.SEPARATOR;

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


    public static List<String[]> matrixInfo(final List<String> stringInfo) {
        Logger logger = Logger.getLogger(DataParcer.class);
        logger.info("parcing data...");
        if (stringInfo.isEmpty()) {
            logger.info("Error of parcing file...");
            return null;
        }
        List<String[]> matrixInfo = new ArrayList<>();
        for (String row : stringInfo) {

            matrixInfo.add(row.split(SEPARATOR));
        }
        return matrixInfo;
    }


}
