package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentType;

/**
 * LeksemaComponent class.
 */
public class LeksemaComponent extends BaseComponent {
    /**
     * punctuation.
     */
    private Symbol punctuation;

    /**
     * method gets leksema type.
     *
     * @return type of leksema.
     */
    @Override
    public ComponentType getType() {
        return ComponentType.LEKSEMA;
    }

    /**
     * method gets punctuation.
     *
     * @return punctuation.
     */
    public Symbol getPunctuation() {
        return punctuation;
    }

    /**
     * method sets punctuation.
     *
     * @param newPunctuation new punctuation.
     */
    public void setPunctuation(final Symbol newPunctuation) {
        punctuation = newPunctuation;
    }

    /**
     * method get length of leksema without punctuation.
     *
     * @return length of word.
     */
    public int getWordLength() {
        if (this.getComponents() == null || this.getComponents().isEmpty()) {
            return 0;
        } else {
            WordComponent wordComponent =
                    (WordComponent) this.getComponents().get(0);
            if (wordComponent == null || wordComponent
                    .getComponents().isEmpty()) {
                return 0;
            }
            return wordComponent.getChildComponentSize();
        }
    }

    /**
     * method gets count of symbols.
     *
     * @param symbol symbol.
     * @return 1 if symbol exist.
     */
    public int getSymbolCount(final String symbol) {
        int count = 0;
        for (Component component : this.getComponents()) {
            WordComponent word = (WordComponent) component;
            for (Component wordComponent : word.getComponents()) {
                Symbol s = (Symbol) wordComponent;
                if (symbol.equals(s.operation())) {
                    count++;
                }
            }
        }
        if (punctuation != null && symbol.equals(punctuation.operation())) {
            count++;
        }
        return count;
    }
}
