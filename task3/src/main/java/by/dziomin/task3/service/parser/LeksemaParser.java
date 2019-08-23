package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.LeksemaComponent;
import by.dziomin.task3.entity.impl.Symbol;
import by.dziomin.task3.entity.impl.WordComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.dziomin.task3.constant.Regex.REGEX_PUNCTUATION;
import static by.dziomin.task3.constant.Regex.REGEX_WORD;

/**
 * leksema parser.
 */
public class LeksemaParser extends BaseComponentParser {
    /**
     * constructor.
     * @param newNextParser newNextParser
     */
    LeksemaParser(final Parser newNextParser) {
        super(newNextParser);
    }
    /**
     * get child component regex method.
     * @return child component regex
     */
    @Override
    public String getChildRegex() {
        return REGEX_WORD;
    }
    /**
     * get child component class method.
     * @return child component class
     */
    @Override
    public Class getChildClass() {
        return WordComponent.class;
    }

    /**
     * method parse leksema.
     * @param text text
     * @param component component
     */
    @Override
    public void parse(final String text, final Component component) {
        String processedString = text;
        if (component instanceof LeksemaComponent) {
            String punctuation = getPunctuation(text);
            if (punctuation != null) {
                Symbol symbol =
                        getComponentFactory().createNewComponent(Symbol.class);
                symbol.setSymbol(punctuation);

                processedString = text.replace(punctuation, "");
                ((LeksemaComponent) component).setPunctuation(symbol);
            }
        }

        super.parse(processedString, component);
    }

    /**
     * method return punctuation.
     * @param text text.
     * @return punctuation.
     */
    private String getPunctuation(final String text) {
        Pattern p = Pattern.compile(REGEX_PUNCTUATION);
        Matcher m = p.matcher(text);
        if (m.find()) {
            return m.group();
        } else {
            return null;
        }
    }
}
