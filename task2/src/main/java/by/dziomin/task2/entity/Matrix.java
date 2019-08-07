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

    public Matrix() {
    }

    /**
     * Matrix matrix.
     * @param newElements newElements.
     */
    public Matrix(final int[][] newElements) {
        countRows = newElements.length;
        countColumns = newElements[0].length;
        elements = newElements;
    }

    /**
     * getCountRows.
     * @return int getCountRows.
     */
    public int getCountRows() {
        return countRows;
    }

//    public void setCountRows(final int newCountRows) {
//        countRows = newCountRows;
//    }
//
public int getCountColumns() {
    return countColumns;
}
//
//    public void setCountColumns(final int newCountColumns) {
//        countColumns = newCountColumns;
//    }
//
public int[][] getElements() {
    return elements;
}

    @Override
    public String toString() {
        return "Matrix{" +
                "elements=" + Arrays.deepToString(elements) +
                '}';
    }
//
//    public void setElements(final String[][] newElements) {
//        elements = newElements;
//    }
}
