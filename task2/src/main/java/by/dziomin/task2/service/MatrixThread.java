package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

/**
 * thread for matrix fill.
 */
public class MatrixThread extends Thread {
    /**
     * matrix.
     */
    private Matrix matrix;
    /**
     * value.
     */
    private int value;
    /**
     * countElementsForInsertValue.
     */
    private int countElementsForInsertValue;

    /**
     * MatrixThread.
     *
     * @param newMatrix                       newMatrix
     * @param newValue                        newValue
     * @param newCountElementsForReplaceValue newCountElementsForReplaceValue
     */
    public MatrixThread(final Matrix newMatrix, final int newValue,
                        final int newCountElementsForReplaceValue) {
        matrix = newMatrix;
        value = newValue;
        countElementsForInsertValue = newCountElementsForReplaceValue;
    }

    /**
     * set method for matrix field.
     *
     * @param newMatrix newMatrix
     */
    public void setMatrix(final Matrix newMatrix) {
        matrix = newMatrix;
    }

    /**
     * run method.
     */
    @Override
    public void run() {
        Logger logger = Logger.getLogger(MatrixThread.class);
        logger.debug("current thread " + getName());
        logger.debug(matrix);
        for (int i = 0; i < countElementsForInsertValue; i++) {
            insertValueInMatrix();
        }

//        Lock locker = new ReentrantLock();
//        locker.lock();
//        locker.unlock();
    }

    /**
     * method insert value in matrix.
     *
     * @return boolean
     */
    private boolean insertValueInMatrix() {
        int[][] elements = matrix.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i][i] == 0) {
                elements[i][i] = value;
                return true;
            }
        }
        return false;
    }

    /**
     * to string method.
     * @return String
     */
    @Override
    public String toString() {
        return "MatrixThread{"
                + ", name=" + getName()
                + ", name=" + getState()
                + ", value=" + value
                + '}';
    }
}
