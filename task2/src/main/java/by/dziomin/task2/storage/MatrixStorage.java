package by.dziomin.task2.storage;

import by.dziomin.task2.entity.Matrix;

/**
 * matrix storage class.
 */
public final class MatrixStorage {
    /**
     * Matix field.
     */
    private Matrix matrix;

    /**
     * default constructor.
     */
    private MatrixStorage() {

    }

    /**
     * singleton getInstance.
     *
     * @return holder.
     */
    public static MatrixStorage getInstance() {
        return MatrixStorageHolder.singletonInstance;
    }

    /**
     * get method for matrix field.
     *
     * @return Matrix
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * set method for matrix field.
     *
     * @param newMatrix newMatrix
     */
    public void setMatrix(final Matrix newMatrix) {
        matrix = newMatrix;
    }

    /**
     * private class.
     * matrix storage holder.
     */

    private static class MatrixStorageHolder {
        /**
         * singletonInstance.
         */
        private static MatrixStorage singletonInstance = new MatrixStorage();
    }
}
