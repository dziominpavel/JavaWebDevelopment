package by.dziomin.task3.constant;

/**
 * Class of regex for text parsing.
 */
public final class Regex {
    /**
     * Regex for parsing text to paragraphs.
     */
    public static final String REGEX_PARAGRAPH = "(?<=[\\.\\!\\?]+)\\t";
    /**
     * Regex for parsing paragraph to sentences.
     */
    public static final String REGEX_SENTENCE = "(?<=[\\.\\!\\?\\t]+)\\s";
    /**
     * Regex for parsing sentence to leksems.
     */
    public static final String REGEX_LEKSEM = "\\s";
    /**
     * Regex for parsing leksem to word and punctuation.
     */
    public static final String REGEX_WORD = "[\\s\\.\\,\\!\\?\\;\\:]+";
    /**
     * Regex for parsing word to symbols.
     */
    public static final String REGEX_SYMBOL = "";
    /**
     * Regex for parsing leksem to word without punctuation.
     */
    public static final String REGEX_PUNCTUATION = "[.!?;:,]+";

    /**
     * default constructor for util class.
     */
    private Regex() {
    }
}
