package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * thread for matrix fill.
 */
public class MatrixThread extends Thread {
    private Matrix matrix;
    private int value;
    private int countElementsForInsertValue;


    public MatrixThread(final Matrix newMatrix, final int newValue,
                        final int newCountElementsForReplaceValue) {
        matrix = newMatrix;
        value = newValue;
        countElementsForInsertValue = newCountElementsForReplaceValue;
    }

    public void setMatrix(final Matrix newMatrix) {
        matrix = newMatrix;
    }


    @Override
    public void run() {
        Logger logger = Logger.getLogger(MatrixThread.class);
//        if (value == 3) {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException newE) {
//                newE.printStackTrace();
//            }
//        }
        logger.debug("current thread " + getName());
        logger.debug(matrix);
        for (int i = 0; i < countElementsForInsertValue; i++) {
            insertValueInMatrix();
        }

//        Lock locker = new ReentrantLock();
//        locker.lock();
//        locker.unlock();
    }


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

    @Override
    public String toString() {
        return "MatrixThread{" +
                ", name=" + getName() +
                ", name=" + getState() +
                ", value=" + value +
                '}';
    }
}
