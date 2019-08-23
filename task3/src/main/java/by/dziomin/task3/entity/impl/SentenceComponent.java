package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

public class SentenceComponent extends BaseComponent {
    @Override
    public ComponentType getType() {
        return ComponentType.SENTENCE;
    }

    public int getWordCount() {
        return this.getComponents().size();
    }
}
