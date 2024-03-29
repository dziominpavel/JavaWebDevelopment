package by.dziomin.task2;


import by.dziomin.task2.entity.Matrix;
import by.dziomin.task2.exception.MatrixException;
import by.dziomin.task2.service.DataParcer;
import by.dziomin.task2.service.DataReader;
import by.dziomin.task2.service.DataValidator;
import by.dziomin.task2.service.MatrixCreator;
import by.dziomin.task2.service.MatrixThreadCreator;
import by.dziomin.task2.service.MultiThreadingMultiplicator;
import by.dziomin.task2.service.MultiplicationMatrixCreator;
import by.dziomin.task2.service.MultiplicationThread;
import by.dziomin.task2.service.SimpleMultiplicator;
import by.dziomin.task2.storage.MatrixStorage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.MATRIX_DATA_FILE_PATH;
import static by.dziomin.task2.settings.MatrixSettings.THREADS_DATA_FILE_PATH;
import static by.dziomin.task2.settings.MultiplicationMatrixSetings.COUNT_TREADS_MUL;

/**
 * main class.
 */
public final class Runner {
    /**
     * default constructor.
     */
    private Runner() {
    }

    /**
     * main method.
     *
     * @param args args.
     * @throws MatrixException MatrixException
     */
    public static void main(final String[] args) throws MatrixException {
        Logger logger = Logger.getLogger(Runner.class);
        logger.info("main thread is started");
        runMultiplicationMatrix();

        try {
            DataReader dataReader = DataReader.getInstance();
            DataParcer dataParcer = DataParcer.getInstance();
            List<String[]> matrixInfo = dataParcer.matrixInfo(
                    dataReader.readFile(MATRIX_DATA_FILE_PATH));
            DataValidator dataValidator = DataValidator.getInstance();
            String[] threadInfo = dataParcer.threadInfo(dataReader.readFile(
                    THREADS_DATA_FILE_PATH));

            if (dataValidator.isValidElements(matrixInfo)
                    && dataValidator.isValidThread(threadInfo)) {
                MatrixCreator matrixCreator = MatrixCreator.getInstance();

                MatrixStorage matrixStorage = MatrixStorage.getInstance();
                matrixStorage.setMatrix(matrixCreator.createMatrix(matrixInfo));
                logger.info(matrixStorage.getMatrix());


                MatrixThreadCreator matrixThreadCreator =
                        MatrixThreadCreator.getInstance();
                List<Thread> threadList =
                        matrixThreadCreator.createTreads(threadInfo);

                for (Thread thread : threadList) {
                    thread.start();
                }

                for (Thread thread : threadList) {
                    join(thread);
                }

                logger.info(matrixStorage.getMatrix());
            }
        } catch (MatrixException e) {
            e.getCause();
        }


        logger.info("main thread is stopped");
    }

    /**
     * method for hoin threads.
     *
     * @param thread thread
     */
    public static void join(final Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException newE) {
            Logger logger = Logger.getLogger(Runner.class);
            logger.info("Error of trying to join thread");
            Thread.currentThread().interrupt();
        }
    }


    /**
     * method run matrix multiplication program.
     */
    private static void runMultiplicationMatrix() {
        Logger logger = Logger.getLogger(Runner.class);
        MultiplicationMatrixCreator creator = new MultiplicationMatrixCreator();
        logger.trace("matrixOne=" + creator.getMatrixOne());
        logger.trace("matrixtwo=" + creator.getMatrixTwo());

        // code for calc multiplication with one thread.
        logger.info("Начало работы SimpleMultiplicator");
        SimpleMultiplicator simpleMatrixMultiplicator =
                new SimpleMultiplicator();
        long startTime = System.currentTimeMillis();
        Matrix result = simpleMatrixMultiplicator.multiplyMatrix(
                creator.getMatrixOne(), creator.getMatrixTwo());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        logger.info("Конец работы SimpleMultiplicator. Время: "
                + elapsedTime);
        logger.trace("result=" + result);

        // code for calc multiplication with several thread.
        logger.info("Начало работы MultiThreadingMultiplicator");

        MultiThreadingMultiplicator multiThreadingMultiplicator
                = new MultiThreadingMultiplicator();
        multiThreadingMultiplicator.initMatrix(creator.getMatrixOne(),
                creator.getMatrixTwo());
        List<MultiplicationThread> multiplicationThreadList
                = new ArrayList<>();


        for (int curThread = 0; curThread < COUNT_TREADS_MUL; curThread++) {
            MultiplicationThread multiplicationThread
                    = new MultiplicationThread(creator.getMatrixOne(),
                    creator.getMatrixTwo(), curThread,
                    multiThreadingMultiplicator.getResult());
            multiplicationThreadList.add(multiplicationThread);
        }
        startTime = System.currentTimeMillis();
        for (MultiplicationThread multiplicationThread
                : multiplicationThreadList) {
            multiplicationThread.start();
            join(multiplicationThread);
        }


        int[][] result1 = multiThreadingMultiplicator.getResult();

        stopTime = System.currentTimeMillis();
        long elapsedTime1 = stopTime - startTime;
        logger.info("Конец работы MultiThreadingMultiplicator."
                +
                " Время: "
                + elapsedTime1);
        logger.trace("result=" + Arrays.deepToString(result1));
    }


}
