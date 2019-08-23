package by.dziomin.task3.service.concatenater;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.impl.BaseComponent;
import by.dziomin.task3.entity.impl.LeksemaComponent;
import by.dziomin.task3.entity.impl.Symbol;

import java.util.List;

/**
 * concatenator service class.
 */
public final class Concatenator {
    /**
     * instance field.
     */
    private static Concatenator instance;

    /**
     * private constructor.
     */
    private Concatenator() {
    }

    /**
     * get instance method.
     *
     * @return instance.
     */
    public static Concatenator getInstance() {
        if (instance == null) {
            instance = new Concatenator();
        }
        return instance;
    }

    /**
     * method run concatenate method and return string.
     *
     * @param component component.
     * @return string.
     */
    public String concatenateToString(final Component component) {
        StringBuilder result = new StringBuilder();
        concatenate(result, component);
        return result.toString();
    }

    /**
     * method concatenates child components.
     *
     * @param newResult concatenated components
     * @param component component
     */
    private void concatenate(final StringBuilder newResult,
                             final Component component) {
        if (component instanceof Symbol) {
            newResult.append(((Symbol) component).operation());
        }

        List<Component> childComponents = component.getComponents();
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

        if (component instanceof LeksemaComponent) {
            Symbol punktuation =
                    ((LeksemaComponent) component).getPunctuation();
            if (punktuation != null) {
                newResult.append(punktuation.operation());
            }
        }
    }
}
