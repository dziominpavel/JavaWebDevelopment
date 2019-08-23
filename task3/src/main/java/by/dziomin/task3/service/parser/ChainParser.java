package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.TextComponent;

/**
 * chain parser.
 */
public final class ChainParser {
    /**
     * chainParser instance.
     */
    private static ChainParser instance;
    /**
     * parser field.
     */
    private Parser parserChain;

    /**
     * constructor run building chain.
     */
    private ChainParser() {
        buildChain();
    }

    /**
     * get instance method.
     *
     * @return instance.
     */
    public static ChainParser getInstance() {
        if (instance == null) {
            instance = new ChainParser();
        }
        return instance;
    }

    /**
     * method builds chain.
     */
    private void buildChain() {
        this.parserChain = new TextParser(
                new ParagraphParser(
                        new SentenceParser(
                                new LeksemaParser(
                                        new WordParser(
                                                new SymbolParser(null))))));
    }

    /**
     * method parses text.
     *
     * @param text text.
     * @return parcing text.
     */
    public Component makeParse(final String text) {
        Component result = new TextComponent();
        parserChain.parse(text, result);
        return result;
    }
}
