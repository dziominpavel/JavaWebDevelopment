package by.dziomin.task3.constant;

public final class Regex {
    public static final String REGEX_PARAGRAPH="(?<=[\\.\\!\\?]+)\\t";
    public static final String REGEX_SENTENCE="(?<=[\\.\\!\\?\\t]+)\\s";
    public static final String REGEX_LEKSEM="\\s";
    public static final String REGEX_WORD="[\\s\\.\\,\\!\\?\\;\\:]+";
    public static final String REGEX_SYMBOL="";
}
