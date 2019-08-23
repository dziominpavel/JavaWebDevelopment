package by.dziomin.task2.settings;

/**
 * setting class for multiplication task.
 */
public final class MultiplicationMatrixSetings {
    /**
     * this setting for additional task2(multiplication)
     * count of threads for multiplication task.
     */
    public static final int COUNT_TREADS_MUL = 4;
    /**
     * this setting for additional task2(multiplication)
     * * count of size of matrix for multiplication task.
     */
    public static final int COUNT_ROWS_MUL = 10;
    /**
     * this setting for additional task2(multiplication)
     * coef. rows per treads.
     */
    public static final int COUNT_ROWS_PER_TREAD
            = COUNT_ROWS_MUL / COUNT_TREADS_MUL;

    /**
     * default constructor.
     */
    private MultiplicationMatrixSetings() {
    }
}
