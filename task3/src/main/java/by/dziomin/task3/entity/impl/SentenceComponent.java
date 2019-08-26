package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

/**
 * sentence component.
 */
public class SentenceComponent extends BaseComponent {
    /**
     * method return sentence type.
     * @return sentence type.
     */
    @Override
    public ComponentType getType() {
        return ComponentType.SENTENCE;
    }

    /**
     * method return count of words.
     * @return count of words.
     */
    public int getWordCount() {
        return this.getComponents().size();
    }
}
