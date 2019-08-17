package by.dziomin.task3.pojo.impl;

import by.dziomin.task3.pojo.Component;
import by.dziomin.task3.pojo.ComponentType;

import java.util.List;

public class Symbol implements Component {

    private String symbol;

    public Symbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(final String newSymbol) {
        symbol = newSymbol;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    @Override
    public void setComponents(final List<Component> components) {
        //not supported
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

}
