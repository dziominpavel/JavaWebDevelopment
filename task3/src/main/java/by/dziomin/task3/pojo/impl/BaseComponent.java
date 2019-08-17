package by.dziomin.task3.pojo.impl;

import by.dziomin.task3.pojo.Component;

import java.util.List;

public abstract class BaseComponent implements Component {

    private List<Component> components;

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(final List<Component> newComponents) {
        components = newComponents;
    }

    public int getChildComponentSize() {
        return components.size();
    }
}
