package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentType;

import java.util.Collections;
import java.util.List;

/**
 * class for Symbol entity.
 */
public class Symbol implements Component {
    /**
     * concrete symbol.
     */
    private char symbol;

    /**
     * set method for symbol field.
     * @param newSymbol newSymbol.
     */
    public void setSymbol(final String newSymbol) {
        symbol = newSymbol.charAt(0);
    }

    /**
     * get method for symbol.
     * @return get method for symbol field.
     */
    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    /**
     * get list of components. (empty for symbol class).
     * @return list of components.
     */
    @Override
    public List<Component> getComponents() {
        return Collections.emptyList();
    }

    /**
     * set components to list. (unsupported for symbol class.)
     * @param components list of components.
     */
    @Override
    public void setComponents(final List<Component> components) {
        throw new UnsupportedOperationException();
    }

    /**
     * method return symbol.
     * @return symbol.
     */
    @Override
    public String operation() {
        return String.valueOf(symbol);
    }
}
