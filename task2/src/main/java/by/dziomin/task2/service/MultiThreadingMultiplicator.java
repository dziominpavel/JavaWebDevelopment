package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;

import static by.dziomin.task2.settings.MultiplicationMatrixSetings.COUNT_ROWS_PER_TREAD;

/**
 * class calculate multiplication of matrix's with several threads.
 */
public class MultiThreadingMultiplicator {

    /**
     * result.
     */
    private int[][] result;

    /**
     * get method for result field.
     *
     * @return result
     */
    public int[][] getResult() {
        return result;
    }

    /**
     * @param matrixOne matrixOne
     * @param matrixTwo matrixTwo
     */
    public void initMatrix(final Matrix matrixOne, final Matrix matrixTwo) {
        result = new int[matrixOne.getCountRows()][matrixTwo.getCountColumns()];

    }

    /**
     * calculate multiplication of matrix's with several threads.
     *
     * @param matrixOne matrixOne
     * @param matrixTwo matrixTwo
     * @param curThread curThread
     * @param newResult newResult
     */
    void multiplyMultiThreadMatrix(final Matrix matrixOne,
                                   final Matrix matrixTwo,
                                   final int curThread,
                                   final int[][] newResult) {
        for (int row = curThread * COUNT_ROWS_PER_TREAD;
             row < COUNT_ROWS_PER_TREAD * (curThread + 1); row++) {

            for (int column = 0; column < matrixTwo.getCountColumns();
                 column++) {

                for (int countTerms = 0; countTerms < matrixTwo.getCountRows();
                     countTerms++) {
                    newResult[row][column] =
                            matrixOne.getElements()[row][countTerms]
                                    * matrixTwo.getElements()
                                    [countTerms][column]
                                    + newResult[row][column];
                }
            }
        }
    }
}
