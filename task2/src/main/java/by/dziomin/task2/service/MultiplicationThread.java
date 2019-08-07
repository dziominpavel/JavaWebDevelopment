package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * thread of calculate multiplication matrix
 */
public class MultiplicationThread extends Thread {

    Logger logger = Logger.getLogger(MultiplicationThread.class);

    MultiThreadingMultiplicator multiThreadingMultiplicator = new MultiThreadingMultiplicator();
    Matrix matrixOne;
    Matrix matrixTwo;
    private int[][] result;
    private int curThread;

    public MultiplicationThread(final Matrix newMatrixOne, final Matrix newMatrixTwo,
                                final int newCurThread, final int[][] newResult) {

        matrixOne = newMatrixOne;
        matrixTwo = newMatrixTwo;
        curThread = newCurThread;
        result = newResult;
    }

    public int[][] getResult() {
        return result;
    }

    @Override
    public void run() {
        logger.trace("Запущен " + currentThread().getName());

        multiThreadingMultiplicator.multiplyMultiThreadMatrix(matrixOne, matrixTwo, curThread,
                result);
        logger.trace("result= " + Arrays.deepToString(getResult()));
        logger.trace("Остановлен " + currentThread().getName());
    }


}
