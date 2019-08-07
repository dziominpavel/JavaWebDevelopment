package by.dziomin.task2.entity;

import java.util.Arrays;

/**
 * Matrix entity.
 */
public class Matrix {
    /**
     * countRows.
     */
    private int countRows = 0;
    /**
     * countColumns.
     */
    private int countColumns = 0;
    /**
     * elements.
     */
    private int[][] elements;


    /**
     * Matrix matrix.
     *
     * @param newElements newElements.
     */
    public Matrix(final int[][] newElements) {
        countRows = newElements.length;
        countColumns = newElements[0].length;
        elements = newElements;
    }

    /**
     * getCountRows.
     *
     * @return int getCountRows.
     */
    public int getCountRows() {
        return countRows;
    }

    /**
     * get method of countColumn field.
     *
     * @return countColumns
     */
    public int getCountColumns() {
        return countColumns;
    }

    /**
     * get method of elements field.
     *
     * @return elements
     */
    public int[][] getElements() {
        return elements;
    }

    /**
     * toString method.
     * @return
     */
    @Override
    public String toString() {
        return "Matrix{"
                + "elements=" + Arrays.deepToString(elements) + '}';
    }

}
