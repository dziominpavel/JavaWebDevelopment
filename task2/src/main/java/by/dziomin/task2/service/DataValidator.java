package by.dziomin.task2.service;

import org.apache.log4j.Logger;

import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.MATRIX_SIZE;

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
        if (matrixInfo.size() != MATRIX_SIZE) {
            logger.error("incorrect matrix size in file");
            return false;
        }

        int numberLine = 0;
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
     * isValidRow.
     *
     * @param rowElements rowElements
     * @param currentRow  currentRow
     * @return boolean.
     */
    private boolean isValidRow(final String[] rowElements,
                                      final int currentRow) {
        Logger logger = Logger.getLogger(DataValidator.class);
        if (rowElements.length != MATRIX_SIZE) {
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
