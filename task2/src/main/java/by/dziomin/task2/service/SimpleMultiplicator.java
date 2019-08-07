package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;
import org.apache.log4j.Logger;

public class SimpleMultiplicator {

    Logger logger = Logger.getLogger(SimpleMultiplicator.class);


    public Matrix multiplyMatrix(Matrix matrixOne, Matrix matrixTwo) {

        int[][] result =
                new int[matrixOne.getCountRows()][matrixTwo.getCountColumns()];

        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[0].length; column++) {
                for (int countTerms = 0; countTerms < matrixTwo.getCountRows(); countTerms++) {
                    result[row][column] =
                            matrixOne.getElements()[row][countTerms]
                                    * matrixTwo.getElements()[countTerms][column]
                                    + result[row][column];
                }
            }
        }
        return new Matrix(result);
    }
}
