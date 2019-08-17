package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.impl.Symbol;

public class WordParser extends BaseComponentParser {
    private static final String REGEX = "abc";

    WordParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getRegex() {
        return REGEX;
    }

    @Override
    public Class getChildClass() {
        return Symbol.class;
    }
}
