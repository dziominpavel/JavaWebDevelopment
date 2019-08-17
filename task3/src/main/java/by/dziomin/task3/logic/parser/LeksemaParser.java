package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.Component;
import by.dziomin.task3.pojo.impl.LeksemaComponent;
import by.dziomin.task3.pojo.impl.Symbol;
import by.dziomin.task3.pojo.impl.WordComponent;

import static by.dziomin.task3.constant.Regex.REGEX_WORD;

public class LeksemaParser extends BaseComponentParser {

    private static final String REGEX = ",.:";

    LeksemaParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public String getChildRegex() {
        return REGEX_WORD;
    }

    @Override
    public Class getChildClass() {
        return WordComponent.class;
    }

    @Override
    public void parse(final String text, final Component component) {
        String processedString = text;
        if (component instanceof LeksemaComponent) {
            String punctuation = getPunctuation(text);
            if (punctuation != null) {
                Symbol symbol = new Symbol(punctuation);
                processedString = text.replace(punctuation, "");
                ((LeksemaComponent) component).setPunctuation(symbol);
            }
        }

        super.parse(processedString, component);
    }

    private String getPunctuation(final String text) { //todo
        if (text.endsWith(",")) {
            return ",";
        }
        return null;
    }
}
