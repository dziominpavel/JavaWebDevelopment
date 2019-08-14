package by.dziomin.task3.compostite.impl;


import by.dziomin.task3.compostite.Component;

public class Leaf implements Component {


    @Override
    public void add(final Component newComponent) {
        System.out.println("Leaf -> add. Doing nothing");
    }

    @Override
    public Component getChild(final int numberComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void operation() {
        System.out.println("Leaf -> Performing operation");
    }

    @Override
    public void remove(final Component newComponent) {
        System.out.println("Leaf -> remove. Doing nothing");
    }
}
