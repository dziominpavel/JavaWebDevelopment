package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.impl.LeksemaComponent;

import static by.dziomin.task3.constant.Regex.REGEX_LEKSEM;

/**
 * Sentence parser class.
 */
public class SentenceParser extends BaseComponentParser {
    /**
     * constructor.
     * @param newNextParser parcer.
     */
    SentenceParser(final Parser newNextParser) {
        super(newNextParser);
    }

    /**
     * get child component regex method.
     * @return child component regex
     */
    @Override
    public String getChildRegex() {
        return REGEX_LEKSEM;
    }
    /**
     * get child component class method.
     * @return child component class
     */
    @Override
    public Class getChildClass() {
        return LeksemaComponent.class;
    }
}
