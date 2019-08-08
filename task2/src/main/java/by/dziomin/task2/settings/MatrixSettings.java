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
    public static final int MATRIX_SIZE = 10;
    /**
     * this setting for general task2.
     * count of threads where 4<=count<=6.
     */
    public static final int COUNT_TREADS = 5;
    /**
     * path to file with matrix information.
     */
    public static final Path MATRIX_DATA_FILE_PATH = Paths.get("data/matrix" +
            ".txt");

    /**
     * private constructor for utility class.
     */
    private MatrixSettings() {
    }
}
