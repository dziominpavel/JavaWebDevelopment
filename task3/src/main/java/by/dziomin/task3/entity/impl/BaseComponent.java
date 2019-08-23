package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.Component;

import java.util.List;

/**
 * base component for all components except symbol.
 */
public abstract class BaseComponent implements Component {
    /**
     * list of components field.
     */
    private List<Component> components;

    /**
     * get method for list of components field.
     *
     * @return list of components
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * set list of components.
     *
     * @param newComponents new list of components.
     */
    public void setComponents(final List<Component> newComponents) {
        components = newComponents;
    }

    /**
     * get size of component list.
     *
     * @return size if components.
     */
    public int getChildComponentSize() {
        return components.size();
    }

}
