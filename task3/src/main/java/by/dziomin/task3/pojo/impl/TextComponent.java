package by.dziomin.task3.pojo.impl;

import by.dziomin.task3.pojo.ComponentType;

public class TextComponent extends BaseComponent {
    @Override
    public ComponentType getType() {
        return ComponentType.TEXT;
    }
}