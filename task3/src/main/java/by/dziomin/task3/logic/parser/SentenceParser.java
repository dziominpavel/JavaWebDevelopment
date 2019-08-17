package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.impl.LeksemaComponent;

public class SentenceParser extends BaseComponentParser {

    private static final String REGEX = "[\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*";

    SentenceParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getRegex() {
        return REGEX;
    }

    @Override
    public Class getChildClass() {
        return LeksemaComponent.class;
    }
}
