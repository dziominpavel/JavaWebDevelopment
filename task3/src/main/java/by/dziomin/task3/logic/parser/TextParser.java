package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.impl.BaseComponent;
import by.dziomin.task3.pojo.impl.ParagraphComponent;

public class TextParser extends BaseComponentParser {

    private static final String REGEX ="\\u0009";

    @Override
    public String getRegex() {
        return REGEX;
    }

    @Override
    public Class getChildClass() {
        return ParagraphComponent.class;
    }

    TextParser(final Parser newNextParser) {
        super(newNextParser);
    }
}
