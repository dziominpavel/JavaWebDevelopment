package by.dziomin.task2.service;

import by.dziomin.task2.entity.Matrix;

import java.util.List;

import static by.dziomin.task2.settings.MatrixSettings.MATRIX_SIZE;


public class MatrixCreator {

    /**
     * MatrixCreator.
     */
    private static MatrixCreator instance;

    /**
     * default constructor.
     */
    private MatrixCreator() {
    }

    /**
     * getInstance MatrixCreator.
     *
     * @return instance.
     */
    public static MatrixCreator getInstance() {

        if (instance == null) {
            instance = new MatrixCreator();
        }
        return instance;
    }


    /**
     * generate matrix.
     */
    public Matrix createMatrix(List<String[]> info) {
        int[][] result = new int[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < info.size(); i++) {
            for (int j = 0; j < info.get(i).length; j++) {
                result[i][j] = Integer.parseInt(info.get(i)[j]);
            }
        }
        return new Matrix(result);
    }


}
