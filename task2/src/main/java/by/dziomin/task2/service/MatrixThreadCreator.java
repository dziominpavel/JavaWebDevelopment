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

    private ArrayList<Integer> countElementsPerThread = new ArrayList();

    public List<Thread> createTreads(Matrix newMatrix) {
        ArrayList<Thread> threadList = new ArrayList<>();
        calcCountElementPerThread(newMatrix);

        for (int i = 0; i < COUNT_THREADS; i++) {
            Thread myThread = new MatrixThread(newMatrix, i + 1,
                    countElementsPerThread.get(i));
            threadList.add(myThread);
        }
        Logger logger = Logger.getLogger(MatrixThreadCreator.class);
        logger.trace(threadList);
        return threadList;
    }

    public void calcCountElementPerThread(Matrix newMatrix) {
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
        countElementsPerThread = result;
    }

}
