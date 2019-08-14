package by.dziomin.task3.compostite.impl;

import by.dziomin.task3.compostite.Component;

public class Client {
    private Component component;

    public Client(Component component) {
        this.component = component;
    }

    public void execute() {
        component.operation();
    }
}
