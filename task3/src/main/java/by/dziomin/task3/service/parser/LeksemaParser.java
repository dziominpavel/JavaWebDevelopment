package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.LeksemaComponent;
import by.dziomin.task3.entity.impl.Symbol;
import by.dziomin.task3.entity.impl.WordComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.dziomin.task3.constant.Regex.REGEX_PUNCTUATION;
import static by.dziomin.task3.constant.Regex.REGEX_WORD;

public class LeksemaParser extends BaseComponentParser {

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
                Symbol symbol =
                        getComponentFactory().createNewComponent(Symbol.class);
                symbol.setSymbol(punctuation);

                processedString = text.replace(punctuation, "");
                ((LeksemaComponent) component).setPunctuation(symbol);
            }
        }

        super.parse(processedString, component);
    }

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
