package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.Symbol;

/**
 * symbol parser class.
 */
public class SymbolParser extends Parser {
    /**
     * constructor symbol parser.
     * @param newNextParser newNextParser
     */
    SymbolParser(final Parser newNextParser) {
        super(newNextParser);
    }

    /**
     * method for pasrce symbol component.
     * @param text text.
     * @param component component.
     */
    @Override
    public void parse(final String text, final Component component) {
        Symbol symbol = (Symbol) component;
        symbol.setSymbol(text);
    }
}
