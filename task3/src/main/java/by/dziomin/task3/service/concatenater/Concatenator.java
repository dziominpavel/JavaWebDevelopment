package by.dziomin.task3.logic.concatenater;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.BaseComponent;
import by.dziomin.task3.entity.impl.LeksemaComponent;
import by.dziomin.task3.entity.impl.Symbol;

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
            newResult.append(((Symbol) newComponent).operation());
        }

        List<Component> childComponents = newComponent.getComponents();
        if (childComponents == null) {
            return;
        }

        String delimiter = "";
        for (Component childComponent : childComponents) {
            if (childComponent instanceof BaseComponent) {
                newResult.append(delimiter);
                delimiter = " ";
            }
            concatenate(newResult, childComponent);
        }

        if (newComponent instanceof LeksemaComponent) {
            Symbol punktuation =
                    ((LeksemaComponent) newComponent).getPunctuation();
            if (punktuation != null) {
                newResult.append(punktuation.operation());
            }
        }
    }
}
