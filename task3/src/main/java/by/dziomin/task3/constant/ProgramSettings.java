package by.dziomin.task3.constant;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * setting class.
 */
public final class ProgramSettings {

    /**
     * path to file with matrix information.
     */
    public static final Path DEFAULT_TEXT_FILE_PATH = Paths.get("data/text"
            + ".txt");


    /**
     * private constructor for utility class.
     */
    private ProgramSettings() {
    }
}
