package by.dziomin.task2.storage;

import by.dziomin.task2.entity.Matrix;

public class MatrixStorage {
    /**
     * instance.
     */
    private static MatrixStorage instance;
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

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(final Matrix newMatrix) {
        matrix = newMatrix;
    }

    /**
     * private class.
     * matrix storage holder.
     */

    private static class MatrixStorageHolder {
        public static MatrixStorage singletonInstance = new MatrixStorage();
    }
}
