package by.dziomin.task3.pojo.impl;

import by.dziomin.task3.pojo.ComponentType;

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
