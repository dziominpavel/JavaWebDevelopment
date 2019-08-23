package by.dziomin.task3.entity.impl;

import by.dziomin.task3.entity.ComponentType;

public class ParagraphComponent extends BaseComponent {
    @Override
    public ComponentType getType() {
        return ComponentType.PARAGRAPH;
    }

    public int getSentenceCount() {
        return this.getComponents().size();
    }
}
