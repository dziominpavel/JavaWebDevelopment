package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.impl.Symbol;

import static by.dziomin.task3.constant.Regex.REGEX_SYMBOL;

public class WordParser extends BaseComponentParser {

    WordParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getChildRegex() {
        return REGEX_SYMBOL;
    }

    @Override
    public Class getChildClass() {
        return Symbol.class;
    }
}
