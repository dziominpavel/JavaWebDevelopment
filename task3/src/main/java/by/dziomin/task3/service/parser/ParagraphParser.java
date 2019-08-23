package by.dziomin.task3.logic.parser;

import by.dziomin.task3.entity.impl.SentenceComponent;

import static by.dziomin.task3.constant.Regex.REGEX_SENTENCE;

public class ParagraphParser extends BaseComponentParser {


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

    @Override
    public Class getChildClass() {
        return SentenceComponent.class;
    }


}
