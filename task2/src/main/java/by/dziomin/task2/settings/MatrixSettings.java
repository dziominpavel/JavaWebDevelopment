package by.dziomin.task2.settings;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * setting class.
 */
public final class MatrixSettings {

    /**
     * this setting for general task2.
     * size matrix NxN where 8<=N<=12.
     */
    public static final int MATRIX_SIZE = 8;
    /**
     * min of possible matrix size.
     */
    public static final int MIN_MATRIX_SIZE = 8;
    /**
     * max of possible matrix size.
     */
    public static final int MAX_MATRIX_SIZE = 12;
    /**
     * this setting for general task2.
     * count of threads where 4<=count<=6.
     */
    public static final int COUNT_THREADS = 5;
    /**
     * min of possible count threads.
     */
    public static final int MIN_COUNT_THREADS = 4;
    /**
     * max of possible count threads.
     */
    public static final int MAX_COUNT_THREADS = 6;
    /**
     * path to file with matrix information.
     */
    public static final Path MATRIX_DATA_FILE_PATH = Paths.get("data/matrix"
            + ".txt");

    /**
     * path to file with matrix information.
     */
    public static final Path THREADS_DATA_FILE_PATH = Paths.get("data/thread"
            + ".txt");
    /**
     * separator in file for parcing matrix info.
     */
    public static final String SEPARATOR = " ";

    /**
     * private constructor for utility class.
     */
    private MatrixSettings() {
    }
}
