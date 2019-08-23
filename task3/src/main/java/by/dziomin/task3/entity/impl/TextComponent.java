package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

/**
 * Text component method.
 */
public class TextComponent extends BaseComponent {
    /**
     * gettyoe method.
     * @return type of component.
     */
    @Override
    public ComponentType getType() {
        return ComponentType.TEXT;
    }
}
