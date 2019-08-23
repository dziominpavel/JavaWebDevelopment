package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

public class TextComponent extends BaseComponent {
    @Override
    public ComponentType getType() {
        return ComponentType.TEXT;
    }
}
