package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

/**
 * paragraph component.
 */
public class ParagraphComponent extends BaseComponent {
    /**
     * get type method.
     * @return type of method.
     */
    @Override
    public ComponentType getType() {
        return ComponentType.PARAGRAPH;
    }

    /**
     * method returns count of sentence.
     * @return sentence count
     */
    public int getSentenceCount() {
        return this.getComponents().size();
    }
}
