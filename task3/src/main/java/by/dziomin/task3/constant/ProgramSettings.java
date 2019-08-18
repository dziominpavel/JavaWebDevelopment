package by.dziomin.task3.constant;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class of program settings.
 */
public final class ProgramSettings {

    /**
     * path to file with text.
     */
    public static final Path DEFAULT_TEXT_FILE_PATH = Paths.get("data/text"
            + ".txt");

    /**
     * private constructor for utility class.
     */
    private ProgramSettings() {
    }
}
