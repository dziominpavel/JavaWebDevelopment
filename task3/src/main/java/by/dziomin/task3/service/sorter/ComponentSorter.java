package by.dziomin.task3.logic.sorter;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentType;

import java.util.Comparator;
import java.util.List;

public class ComponentSorter {
    private static ComponentSorter instance;

    private ComponentSorter() {
    }

    public static ComponentSorter getInstance() {
        if (instance == null) {
            instance = new ComponentSorter();
        }
        return instance;
    }

    public <T extends Component> Component sortComponent(final Component newComponent,
                final ComponentType type, final Comparator<T> newComparator) {
        if (type.equals(newComponent.getType())) {
            List<T> components = (List<T>) newComponent.getComponents();
            components.sort(newComparator);
        } else {
            newComponent.getComponents().forEach(c -> sortComponent(c, type,
                    newComparator));
        }
        return newComponent;
    }
}
