package by.dziomin.task2.entity;

import java.util.Arrays;

/**
 * Matrix entity.
 */
public class Matrix {

    /**
     * countRows.
     */
    private int countRows;
    /**
     * countColumns.
     */
    private int countColumns;
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
     * set method for elements field.
     *
     * @param newElements newElements
     */
    public void setElements(final int[][] newElements) {
        elements = newElements;
    }

    /**
     * toString method.
     *
     * @return String.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Matrix is: ");
        for (int[] row : elements) {
            stringBuilder.append("\n").append(Arrays.toString(row));
        }
        return stringBuilder.toString();
    }

}
