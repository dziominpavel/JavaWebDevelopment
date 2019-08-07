package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;

import static by.dziomin.task2.service.MatrixSettings.COUNT_ROWS;

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
        int[][] matrixElementsOne = new int[COUNT_ROWS][COUNT_ROWS];
        int[][] matrixElementsTwo = new int[COUNT_ROWS][COUNT_ROWS];

        for (int i = 0; i < COUNT_ROWS; i++) {
            for (int j = 0; j < COUNT_ROWS; j++) {
                matrixElementsOne[i][j] = 1;
                matrixElementsTwo[i][j] = 2;
            }
        }
        matrixOne = new Matrix(matrixElementsOne);
        matrixTwo = new Matrix(matrixElementsTwo);
    }

    public Matrix getMatrixOne() {
        return matrixOne;
    }


    public Matrix getMatrixTwo() {
        return matrixTwo;
    }

}
