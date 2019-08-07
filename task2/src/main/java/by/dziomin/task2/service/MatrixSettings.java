package by.dziomin.task2.service;

/**
 * setting class.
 */
public final class MatrixSettings {
    /**
     * count of threads for multiplication task.
     */
    public static final int COUNT_TREADS = 4;
    /**
     * * count of size of matrix for multiplication task.
     */
    static final int COUNT_ROWS = 500;
    /**
     * coef. rows per treads.
     */
    static final int COUNT_ROWS_PER_TREAD = COUNT_ROWS / COUNT_TREADS;

//    /**
//     * this setting for general task2.
//     */
    /**
     * private constructor for utility class.
     */
    private MatrixSettings() {
    }
}
