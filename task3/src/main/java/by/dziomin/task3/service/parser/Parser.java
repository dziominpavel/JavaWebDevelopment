package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentFactory;

public abstract class Parser {
    private Parser nextParser;
    private ComponentFactory componentFactory;

    Parser(final Parser newNextParser) {
        nextParser = newNextParser;
        this.componentFactory = ComponentFactory.getInstance();
    }

    public void parse(String text, final Component newResult) {
        if (nextParser != null) {
            nextParser.parse(text, newResult);
        }
    }

    ComponentFactory getComponentFactory() {
        return componentFactory;
    }
}
