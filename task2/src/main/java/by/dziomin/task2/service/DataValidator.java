package by.dziomin.task2.service;

import org.apache.log4j.Logger;

import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.COUNT_THREADS;
import static by.dziomin.task2.settings.MatrixSettings.MATRIX_SIZE;
import static by.dziomin.task2.settings.MatrixSettings.MAX_COUNT_THREADS;
import static by.dziomin.task2.settings.MatrixSettings.MAX_MATRIX_SIZE;
import static by.dziomin.task2.settings.MatrixSettings.MIN_COUNT_THREADS;
import static by.dziomin.task2.settings.MatrixSettings.MIN_MATRIX_SIZE;

/**
 * DataParcer.
 */
public final class DataValidator {
    /**
     * DataValidator.
     */
    private static DataValidator instance;

    /**
     * default constructor.
     */
    private DataValidator() {
        //default constructor.
    }

    /**
     * getInstance DataValidator.
     *
     * @return instance.
     */
    public static DataValidator getInstance() {

        if (instance == null) {
            instance = new DataValidator();
        }
        return instance;
    }

    /**
     * validateElements.
     *
     * @param matrixInfo matrixInfo.
     * @return List<String>
     */
    public boolean isValidElements(final List<String[]> matrixInfo) {
        Logger logger = Logger.getLogger(DataValidator.class);
        logger.trace("validate data...");
        if (!isValidProgrammSettings()) {
            return false;
        }

        if (matrixInfo.size() != MIN_MATRIX_SIZE) {
            logger.error("incorrect matrix size in file");
            return false;
        }

        int numberLine = 1;
        for (String[] row : matrixInfo) {
            if (isValidRow(row, numberLine)) {
                for (String element : row) {
                    if (!isValidElement(element, numberLine)) {
                        return false;
                    }
                }
                numberLine++;
            }
        }
        return true;

    }

    /**
     * isValidProgrammSettings.
     *
     * @return boolean
     */
    private boolean isValidProgrammSettings() {
        Logger logger = Logger.getLogger(DataValidator.class);

        if (MATRIX_SIZE < MIN_MATRIX_SIZE
                || MATRIX_SIZE > MAX_MATRIX_SIZE) {
            logger.error("Incorrect size of matrix. Change "
                    + "program settings");
            return false;
        }
        if (COUNT_THREADS < MIN_COUNT_THREADS
                || COUNT_THREADS > MAX_COUNT_THREADS) {
            logger.error("Incorrect count of threads. Change "
                    + "program settings");
            return false;
        }
        return true;
    }

    /**
     * isValidRow.
     *
     * @param rowElements rowElements
     * @param currentRow  currentRow
     * @return boolean.
     */
    private boolean isValidRow(final String[] rowElements,
                               final int currentRow) {
        Logger logger = Logger.getLogger(DataValidator.class);
        if (rowElements.length == MIN_MATRIX_SIZE) {
            logger.trace("line " + currentRow + " is valid");
            return true;
        } else {
            logger.error("line " + currentRow + " is not valid");
            return false;
        }

    }

    /**
     * isValidElement.
     *
     * @param element    element
     * @param currentRow currentRow
     * @return boolean
     */
    private boolean isValidElement(final String element,
                                   final int currentRow) {
        Logger logger = Logger.getLogger(DataValidator.class);
        try {
            Integer.parseInt(element);
            logger.trace("element " + element + " in line " + currentRow
                    + " is valid");
            return true;
        } catch (NumberFormatException e) {
            logger.error("element " + element + " in line " + currentRow
                    + " is not valid");
            return false;
        }
    }
}
