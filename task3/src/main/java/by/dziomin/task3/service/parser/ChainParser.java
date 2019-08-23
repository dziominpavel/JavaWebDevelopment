package by.dziomin.task3.logic.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.TextComponent;

public class ChainParser {
    private static ChainParser instance;
    private Parser parserChain;

    private ChainParser() {
        buildChain();
    }

    public static ChainParser getInstance() {
        if (instance == null) {
            instance = new ChainParser();
        }
        return instance;
    }

    private void buildChain() {
        this.parserChain = new TextParser(
                new ParagraphParser(
                        new SentenceParser(
                                new LeksemaParser(
                                        new WordParser(
                                                new SymbolParser(null))))));
    }

    public Component makeParse(String text) {
        Component result = new TextComponent();
        parserChain.parse(text, result);
        return result;
    }
}
