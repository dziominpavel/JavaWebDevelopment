package by.dziomin.task3.service.sorter;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentType;

import java.util.Comparator;
import java.util.List;

/**
 * component sorter service class.
 */
public final class ComponentSorter {
    /**
     * component sorter instance.
     */
    private static ComponentSorter instance;

    /**
     * constructor.
     */
    private ComponentSorter() {
    }

    /**
     * get instance method.
     *
     * @return instance.
     */
    public static ComponentSorter getInstance() {
        if (instance == null) {
            instance = new ComponentSorter();
        }
        return instance;
    }

    /**
     * method sorts component.
     *
     * @param component  component
     * @param type       of component
     * @param comparator comparator
     * @param <T>        subclass of Component.
     * @return subclass of Component.
     */
    public <T extends Component> Component sortComponent(
            final Component component,
            final ComponentType type,
            final Comparator<T> comparator) {
        if (type.equals(component.getType())) {
            List<T> components = (List<T>) component.getComponents();
            components.sort(comparator);
        } else {
            component.getComponents().forEach(c -> sortComponent(c, type,
                    comparator));
        }
        return component;
    }
}
