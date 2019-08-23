package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.impl.SentenceComponent;

import static by.dziomin.task3.constant.Regex.REGEX_SENTENCE;

/**
 * paragraph parcer class.
 */
public class ParagraphParser extends BaseComponentParser {

    /**
     * constructor.
     * @param newNextParser newNextParser
     */
    ParagraphParser(final Parser newNextParser) {
        super(newNextParser);
    }

    /**
     * get regex for child component.
     *
     * @return String.
     */
    @Override
    public String getChildRegex() {
        return REGEX_SENTENCE;
    }
    /**
     * get child component class method.
     * @return child component class
     */
    @Override
    public Class getChildClass() {
        return SentenceComponent.class;
    }


}
