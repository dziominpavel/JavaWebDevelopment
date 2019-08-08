package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;

/**
 * class calculate multiplication of matrix's with one thread.
 */
public class SimpleMultiplicator {

    /**
     * calculate multiplication of matrix's with one thread.
     *
     * @param matrixOne matrixOne
     * @param matrixTwo matrixTwo
     * @return Matrix.
     */
    public Matrix multiplyMatrix(final Matrix matrixOne,
                                 final Matrix matrixTwo) {

        int[][] result =
                new int[matrixOne.getCountRows()][matrixTwo.getCountColumns()];

        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[0].length; column++) {
                for (int countTerms = 0; countTerms < matrixTwo.getCountRows();
                     countTerms++) {
                    result[row][column] =
                            matrixOne.getElements()[row][countTerms]
                                    * matrixTwo.getElements()
                                    [countTerms][column]
                                    + result[row][column];
                }
            }
        }
        return new Matrix(result);
    }
}
