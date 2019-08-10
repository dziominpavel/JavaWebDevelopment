package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.COUNT_THREADS;

/**
 * creator matirx threads.
 */
public final class MatrixThreadCreator {
    /**
     * MatrixCreator.
     */
    private static MatrixThreadCreator instance;

    /**
     * countElementsPerThread.
     */
    private ArrayList<Integer> countElementsPerThread;

    /**
     * default constructor.
     */
    private MatrixThreadCreator() {
    }

    /**
     * getInstance MatrixCreator.
     *
     * @return instance.
     */
    public static MatrixThreadCreator getInstance() {

        if (instance == null) {
            instance = new MatrixThreadCreator();
        }
        return instance;
    }

    /**
     * method creates and initializes threads.
     *
     * @param newMatrix  newMatrix
     * @param threadInfo threadInfo
     * @return List<Thread>
     */
    public List<Thread> createTreads(final Matrix newMatrix,
                                     final String[] threadInfo) {
        ArrayList<Thread> threadList = new ArrayList<>();
        countElementsPerThread = calcCountElementPerThread(newMatrix);

        for (int i = 0; i < COUNT_THREADS; i++) {
            int value = Integer.parseInt(threadInfo[i]);
            Thread myThread = new MatrixThread(newMatrix, value,
                    countElementsPerThread.get(i));
            threadList.add(myThread);
        }
        Logger logger = Logger.getLogger(MatrixThreadCreator.class);
        logger.trace(threadList);
        return threadList;


    }

    /**
     * method calculates count elements per thread and set to
     * countElementsPerThread field.
     *
     * @param newMatrix newMatrix
     * @return ArrayList<Integer>
     */
    private ArrayList<Integer> calcCountElementPerThread(
            final Matrix newMatrix) {
        ArrayList<Integer> result = new ArrayList();
        int allCount = newMatrix.getCountRows();
        int countFullThreads = allCount / COUNT_THREADS;
        int countAddThreads = allCount % COUNT_THREADS;
        Logger logger = Logger.getLogger(MatrixThreadCreator.class);

        for (int i = 0; i < COUNT_THREADS; i++) {
            result.add(countFullThreads);
        }

        for (int i = 0; i < countAddThreads; i++) {
            int temp = result.get(i);
            result.set(i, temp + 1);
        }
        logger.debug("countElementsPerThread " + result);
        return result;
    }

}
