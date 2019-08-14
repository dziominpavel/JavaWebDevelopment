package by.dziomin.task3.settings;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * setting class.
 */
public final class ProgramSettings {

    /**
     * path to file with matrix information.
     */
    public static final Path TEXT_FILE_PATH = Paths.get("data/textTemp"
            + ".txt");


    /**
     * private constructor for utility class.
     */
    private ProgramSettings() {
    }
}
