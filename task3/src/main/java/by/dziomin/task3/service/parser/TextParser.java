package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.impl.ParagraphComponent;

import static by.dziomin.task3.constant.Regex.REGEX_PARAGRAPH;

/**
 * Text parcer class.
 */
public class TextParser extends BaseComponentParser {

    /**
     * constructor.
     *
     * @param newNextParser newNextParser
     */
    TextParser(final Parser newNextParser) {
        super(newNextParser);
    }

    /**
     * get child component regex method.
     * @return child component regex
     */
    @Override
    public String getChildRegex() {
        return REGEX_PARAGRAPH;
    }
    /**
     * get child class method.
     * @return child component class.
     */
    @Override
    public Class getChildClass() {
        return ParagraphComponent.class;
    }
}
