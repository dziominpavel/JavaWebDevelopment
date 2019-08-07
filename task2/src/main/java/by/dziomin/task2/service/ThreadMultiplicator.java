package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

import static by.dziomin.task2.service.MatrixSettings.COUNT_ROWS_PER_TREAD;

public class ThreadMultiplicator {

    Logger logger = Logger.getLogger(ThreadMultiplicator.class);

    private int[][] result;
    private int curThread = 0;

    public int[][] getResult() {
        return result;
    }

    public void initMatrix(final Matrix matrixOne, final Matrix matrixTwo) {
        result = new int[matrixOne.getCountRows()][matrixTwo.getCountColumns()];

    }

    public void multiplyMultiThreadMatrix(Matrix matrixOne, Matrix matrixTwo,
                                          int curThread, int[][] result) {
        for (int row = curThread * COUNT_ROWS_PER_TREAD; row < COUNT_ROWS_PER_TREAD * (curThread + 1); row++) {

            for (int column = 0; column < matrixTwo.getCountColumns(); column++) {

                for (int countTerms = 0; countTerms < matrixTwo.getCountRows(); countTerms++) {
                    result[row][column] = matrixOne.getElements()[row][countTerms]
                            * matrixTwo.getElements()[countTerms][column] + result[row][column];
                }
            }
        }
    }
}
