package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;

import static by.dziomin.task2.service.MatrixSettings.COUNT_ROWS;

public class MatrixCreator {

    private final static int[][] matrixElementsOne = new int[COUNT_ROWS][COUNT_ROWS];
    private final static int[][] matrixElementsTwo = new int[COUNT_ROWS][COUNT_ROWS];


    public Matrix matrixOne = new Matrix(matrixElementsOne);
    public Matrix matrixTwo = new Matrix(matrixElementsTwo);

    public MatrixCreator() {
        for (int i = 0; i < COUNT_ROWS; i++) {
            for (int j = 0; j < COUNT_ROWS; j++) {
                matrixElementsOne[i][j] = 1;
                matrixElementsTwo[i][j] = 2;
            }
        }
    }

    public Matrix getMatrixOne() {
        return matrixOne;
    }

    public void setMatrixOne(final Matrix newMatrixOne) {
        matrixOne = newMatrixOne;
    }

    public Matrix getMatrixTwo() {
        return matrixTwo;
    }

    public void setMatrixTwo(final Matrix newMatrixTwo) {
        matrixTwo = newMatrixTwo;
    }
}
