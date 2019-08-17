package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.impl.BaseComponent;
import by.dziomin.task3.pojo.impl.SentenceComponent;

public class ParagraphParser extends BaseComponentParser {

    private static final String REGEX ="[^(\\.|!|\\?)]+)(\\.|!|\\?";

    ParagraphParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getRegex() {
        return REGEX;
    }

    @Override
    public Class getChildClass() {
        return SentenceComponent.class;
    }


}
