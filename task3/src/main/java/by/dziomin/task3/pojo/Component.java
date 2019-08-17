package by.dziomin.task3.pojo;

import java.util.List;

public interface Component {

    ComponentType getType();

    void setComponents(List<Component> components);

    List<Component> getComponents();
}
