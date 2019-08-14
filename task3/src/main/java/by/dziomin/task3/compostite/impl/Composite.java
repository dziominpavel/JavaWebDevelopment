package by.dziomin.task3.compostite.impl;

import by.dziomin.task3.compostite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements by.dziomin.task3.compostite.Component {

    private List<Component> components=new ArrayList<>();

    @Override
    public void add(final Component newComponent) {
        System.out.println("Composite -> Adding component");
        components.add(newComponent);
    }

    @Override
    public Component getChild(final int index) {
        System.out.println("Composite -> Getting component");
        return components.get(index);
    }

    @Override
    public void operation() {
        System.out.println("Composite -> Call children operations");
        int size = components.size();
        for (int i = 0; i < size; i++) {
            components.get(i).operation();
        }


    }

    @Override
    public void remove(final Component component) {
        System.out.println("Composite -> Removing component");
        components.remove(component);
    }
}