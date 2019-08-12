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
     * constant string "line".
     */
    private static final String LINE = "line";
    /**
     * constant string "is VALID".
     */
    private static final String VALID = "is valid";
    /**
     * constant string "is not VALID".
     */
    private static final String NOT_VALID = "is not valid";
    /**
     * constant string "EL".
     */
    private static final String EL = "element";
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
        if (!isValidProgramSettings()) {
            return false;
        }

        if (matrixInfo.size() != MATRIX_SIZE) {
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
     * isValidProgramSettings.
     *
     * @return boolean
     */
    private boolean isValidProgramSettings() {
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

        if (rowElements.length == MATRIX_SIZE) {
            logger.trace(LINE + currentRow + VALID);
            return true;
        } else {
            logger.error(LINE + currentRow + NOT_VALID);
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
            logger.trace(EL + element + LINE + currentRow
                    + VALID);
            return true;
        } catch (NumberFormatException e) {
            logger.error(EL + element + LINE + currentRow
                    + NOT_VALID);
            return false;
        }
    }

    /**
     * isValidThread.
     *
     * @param newThreadInfo newThreadInfo
     * @return boolean
     */
    public boolean isValidThread(final String[] newThreadInfo) {
        Logger logger = Logger.getLogger(DataValidator.class);
        logger.trace("validate thread data...");
        if (!isValidProgramSettings()) {
            return false;
        }

        int numberLine = 1;
        if (newThreadInfo.length == COUNT_THREADS) {
            logger.trace(LINE + numberLine + VALID);
            for (String element : newThreadInfo) {
                if (!isValidElement(element, numberLine)) {
                    return false;
                }
            }
            return true;
        } else {
            logger.error(LINE + numberLine + NOT_VALID);
            return false;
        }


    }
}
