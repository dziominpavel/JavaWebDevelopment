package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

/**
 * Word component class.
 */
public class WordComponent extends BaseComponent {

    /**
     * gettype method for word component.
     * @return word component type
     */
    @Override
    public ComponentType getType() {
        return ComponentType.WORD;
    }
}
