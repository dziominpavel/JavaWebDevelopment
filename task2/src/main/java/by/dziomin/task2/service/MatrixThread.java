package by.dziomin.task2.service;

import by.dziomin.task2.storage.MatrixStorage;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * thread for matrix fill.
 */
public class MatrixThread extends Thread {

    /**
     * value.
     */
    private int value;
    /**
     * countElementsForInsertValue.
     */
    private int countElementsForInsertValue;
    /**
     * locker.
     */
    private Lock locker;

    /**
     * MatrixThread.
     *
     * @param newValue                        newValue
     * @param newCountElementsForReplaceValue newCountElementsForReplaceValue
     */
    MatrixThread(final int newValue,
                 final int newCountElementsForReplaceValue,
                 final Lock newLocker) {
        value = newValue;
        countElementsForInsertValue = newCountElementsForReplaceValue;
        locker=newLocker;
    }

    /**
     * run method.
     */
    @Override
    public void run() {
        Logger logger = Logger.getLogger(MatrixThread.class);
        MatrixStorage matrixStorage = MatrixStorage.getInstance();
        for (int i = 0; i < countElementsForInsertValue; i++) {
            locker.lock();
            logger.debug("current thread " + getName());
            insertValueInMatrix();
            logger.debug(matrixStorage.getMatrix());
            locker.unlock();
        }

//
    }

    /**
     * method insert value in matrix.
     *
     * @return boolean
     */
    private boolean insertValueInMatrix() {
        MatrixStorage matrixStorage = MatrixStorage.getInstance();
        int[][] elements = matrixStorage.getMatrix().getElements();
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
     *
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
