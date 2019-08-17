package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.impl.LeksemaComponent;

import static by.dziomin.task3.constant.Regex.REGEX_LEKSEM;

public class SentenceParser extends BaseComponentParser {

    SentenceParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getChildRegex() {
        return REGEX_LEKSEM;
    }

    @Override
    public Class getChildClass() {
        return LeksemaComponent.class;
    }
}
