package by.dziomin.task3.logic.concatenater;

import by.dziomin.task3.pojo.Component;
import by.dziomin.task3.pojo.impl.LeksemaComponent;
import by.dziomin.task3.pojo.impl.Symbol;

import java.util.List;

public class Concatenator {
    private static Concatenator instance;

    private Concatenator() {
    }

    public static Concatenator getInstance() {
        if (instance == null) {
            instance = new Concatenator();
        }
        return instance;
    }

    public String concatenateToString(Component component) {
        StringBuilder result = new StringBuilder();
        concatenate(result, component);
        return result.toString();
    }

    private void concatenate(final StringBuilder newResult, final Component newComponent) {
        if (newComponent instanceof Symbol) {
            newResult.append(((Symbol) newComponent).getSymbol());
        }

        List<Component> childComponents = newComponent.getComponents();
        if (childComponents == null) {
            return;
        }

        for (Component childComponent : childComponents) {
            concatenate(newResult, childComponent);
            newResult.append(" ");
        }

        if (newComponent instanceof LeksemaComponent) {
            //todo remove space before punctuation
            Symbol punktuation =
                    ((LeksemaComponent) newComponent).getPunctuation();
            newResult.append(punktuation.getSymbol());
        }
    }
}
