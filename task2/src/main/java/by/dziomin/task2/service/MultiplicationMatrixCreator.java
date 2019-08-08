package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;

import static by.dziomin.task2.settings.MultiplicationMatrixSetings.COUNT_ROWS_MUL;

/**
 * class generate two matrix's for multiplication.
 */
public class MultiplicationMatrixCreator {

    /**
     * matrix One.
     */
    private Matrix matrixOne;
    /**
     * matrix Two.
     */
    private Matrix matrixTwo;

    /**
     * generate two tests matrix for multiplication.
     */
    public MultiplicationMatrixCreator() {
        int[][] matrixElementsOne = new int[COUNT_ROWS_MUL][COUNT_ROWS_MUL];
        int[][] matrixElementsTwo = new int[COUNT_ROWS_MUL][COUNT_ROWS_MUL];

        for (int i = 0; i < COUNT_ROWS_MUL; i++) {
            for (int j = 0; j < COUNT_ROWS_MUL; j++) {
                matrixElementsOne[i][j] = 1;
                matrixElementsTwo[i][j] = 2;
            }
        }
        matrixOne = new Matrix(matrixElementsOne);
        matrixTwo = new Matrix(matrixElementsTwo);
    }

    /**
     * get method for matrixOne.
     *
     * @return matrixOne
     */
    public Matrix getMatrixOne() {
        return matrixOne;
    }

    /**
     * get method for matrixOne.
     *
     * @return matrixTwo
     */
    public Matrix getMatrixTwo() {
        return matrixTwo;
    }

}
