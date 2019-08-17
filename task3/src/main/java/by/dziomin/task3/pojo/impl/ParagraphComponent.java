package by.dziomin.task3.pojo.impl;

import by.dziomin.task3.pojo.ComponentType;

public class ParagraphComponent extends BaseComponent {
    @Override
    public ComponentType getType() {
        return ComponentType.PARAGRAPH;
    }

    public int getSentenceCount() {
        return this.getComponents().size();
    }
}
