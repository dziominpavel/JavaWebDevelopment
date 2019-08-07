package by.dziomin.task2;


import by.dziomin.task2.entity.Matrix;
import by.dziomin.task2.service.MatrixCreator;
import by.dziomin.task2.service.MyThread;
import by.dziomin.task2.service.SimpleMultiplicator;
import by.dziomin.task2.service.ThreadMultiplicator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.task2.service.MatrixSettings.COUNT_TREADS;

public class Runner extends Thread {
    static Logger logger = Logger.getLogger(Runner.class);


    public static void main(String[] args) {
        logger.info("Запущен гл поток " + currentThread().getName());
        MatrixCreator creator = new MatrixCreator();
        logger.trace("matrixOne=" + creator.getMatrixOne());
        logger.trace("matrixtwo=" + creator.getMatrixTwo());


        logger.info("Начало работы SimpleMultiplicator");
        SimpleMultiplicator simpleMatrixMultiplicator =
                new SimpleMultiplicator();
        long startTime = System.currentTimeMillis();
        Matrix result = simpleMatrixMultiplicator.multiplyMatrix(creator.getMatrixOne(),
                creator.getMatrixTwo());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        logger.info("Конец работы SimpleMultiplicator. Время: " + elapsedTime);
        logger.trace("result=" + result);


        logger.info("Начало работы ThreadMultiplicator");

        ThreadMultiplicator threadMultiplicator = new ThreadMultiplicator();
        threadMultiplicator.initMatrix(creator.getMatrixOne(), creator.getMatrixTwo());

        List<MyThread> myThreadList = new ArrayList<MyThread>();



        for (int curThread = 0; curThread < COUNT_TREADS; curThread++) {
            MyThread myThread = new MyThread(creator.getMatrixOne(), creator.getMatrixTwo(), curThread,
                    threadMultiplicator.getResult());

            myThreadList.add(myThread);
        }
        startTime = System.currentTimeMillis();
        for (MyThread myThread : myThreadList) {
            myThread.start();

            try {
                myThread.join();
            } catch (InterruptedException newE) {
                newE.printStackTrace();
            }
        }


        int[][] result1 = threadMultiplicator.getResult();

        stopTime = System.currentTimeMillis();
        long elapsedTime1 = stopTime - startTime;
        logger.info("Конец работы ThreadMultiplicator. Время: " + elapsedTime1);
        logger.trace("result=" + Arrays.deepToString(result1));

        logger.info("Остановлен гл поток " + currentThread().getName());

    }


}
