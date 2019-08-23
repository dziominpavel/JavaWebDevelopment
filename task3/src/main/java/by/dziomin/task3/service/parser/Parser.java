package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;
import by.dziomin.task3.entity.ComponentFactory;

/**
 * Parser abstract class for symbolParcer and BaseComponentsParser.
 */
public abstract class Parser {
    /**
     * Parcer field.
     */
    private Parser nextParser;
    /**
     * factory of components field.
     */
    private ComponentFactory componentFactory;

    /**
     * construnctor.
     * @param newNextParser newNextParser.
     */
    Parser(final Parser newNextParser) {
        nextParser = newNextParser;
        componentFactory = ComponentFactory.getInstance();
    }

    /**
     * method parses text.
     * @param text text
     * @param newResult newResult.
     */
    public void parse(final String text, final Component newResult) {
        if (nextParser != null) {
            nextParser.parse(text, newResult);
        }
    }

    /**
     * method gets factory of components.
     * @return componentFactory.
     */
    ComponentFactory getComponentFactory() {
        return componentFactory;
    }
}
