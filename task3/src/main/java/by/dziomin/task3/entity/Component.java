package by.dziomin.task3.entity;

import java.util.List;

/**
 * Component class.
 */
public interface Component {
    /**
     * method return type of component.
     * @return component type.
     */
    ComponentType getType();

    /**
     * method return list of child components.
     * @return list of components.
     */
    List<Component> getComponents();

    /**
     * set components method.
     * @param components list of components.
     */
    void setComponents(List<Component> components);

    /**
     * default method operation.
     * @return clear string.
     */
    default String operation() {
        return "";
    }
}
