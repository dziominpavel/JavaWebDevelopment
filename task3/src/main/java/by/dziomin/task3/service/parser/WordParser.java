package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.impl.Symbol;

import static by.dziomin.task3.constant.Regex.REGEX_SYMBOL;

public class WordParser extends BaseComponentParser {

    WordParser(final Parser newNextParser) {
        super(newNextParser);
    }
    /**
     * get child component regex method.
     * @return child component regex
     */
    @Override
    public String getChildRegex() {
        return REGEX_SYMBOL;
    }
    /**
     * get child component class method.
     * @return child component class
     */
    @Override
    public Class getChildClass() {
        return Symbol.class;
    }
}
