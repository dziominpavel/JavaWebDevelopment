package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.Component;
import by.dziomin.task3.pojo.impl.Symbol;

public class SymbolParser extends Parser {

    SymbolParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public void parse(final String text, final Component component) {
        Symbol symbol = (Symbol) component;
        symbol.setSymbol(text);
    }
}
