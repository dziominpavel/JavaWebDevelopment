package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * thread of calculate multiplication matrix.
 */
public class MultiplicationThread extends Thread {


    /**
     * matrix One.
     */
    private Matrix matrixOne;
    /**
     * matrix Two.
     */
    private Matrix matrixTwo;
    /**
     * elements of result matrix.
     */
    private int[][] result;
    /**
     * current thread.
     */
    private int curThread;

    /**
     * constructor.
     *
     * @param newMatrixOne newMatrixOne.
     * @param newMatrixTwo newMatrixTwo.
     * @param newCurThread newCurThread.
     * @param newResult    newResult.
     */
    public MultiplicationThread(final Matrix newMatrixOne,
                                final Matrix newMatrixTwo,
                                final int newCurThread,
                                final int[][] newResult) {

        matrixOne = newMatrixOne;
        matrixTwo = newMatrixTwo;
        curThread = newCurThread;
        result = newResult;
    }

    /**
     * get method for result field.
     * @return int[][]
     */
    private int[][] getResult() {
        return result;
    }

    /**
     * run method.
     */
    @Override
    public void run() {

        Logger logger = Logger.getLogger(MultiplicationThread.class);
        logger.trace("Запущен " + currentThread().getName());

        MultiThreadingMultiplicator multiThreadingMultiplicator
                = new MultiThreadingMultiplicator();
        multiThreadingMultiplicator.multiplyMultiThreadMatrix(matrixOne,
                matrixTwo, curThread, result);
        logger.trace("result= " + Arrays.deepToString(getResult()));
        logger.trace("Остановлен " + currentThread().getName());
    }


}
