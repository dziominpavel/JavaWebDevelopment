package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentType;

public class LeksemaComponent extends BaseComponent {

    private Symbol punctuation;

    @Override
    public ComponentType getType() {
        return ComponentType.LEKSEMA;
    }

    public Symbol getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(final Symbol newPunctuation) {
        punctuation = newPunctuation;
    }

    public int getWordLength() {
        if (this.getComponents() == null || this.getComponents().isEmpty()) {
            return 0;
        } else {
            WordComponent wordComponent = (WordComponent) this.getComponents().get(0);
            if (wordComponent == null || wordComponent.getComponents().isEmpty()) {
                return 0;
            }
            return wordComponent.getChildComponentSize();
        }
    }

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
