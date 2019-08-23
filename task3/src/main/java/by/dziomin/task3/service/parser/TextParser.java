package by.dziomin.task3.logic.parser;

import by.dziomin.task3.entity.impl.ParagraphComponent;

import static by.dziomin.task3.constant.Regex.REGEX_PARAGRAPH;

/**
 * Text parcer class.
 */
public class TextParser extends BaseComponentParser {

    /**
     * constructor.
     * @param newNextParser newNextParser
     */
    TextParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getChildRegex() {
        return REGEX_PARAGRAPH;
    }

    @Override
    public Class getChildClass() {
        return ParagraphComponent.class;
    }
}
