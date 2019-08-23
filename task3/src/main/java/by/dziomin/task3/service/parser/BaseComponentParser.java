package by.dziomin.task3.service.parser;

import by.dziomin.task3.entity.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Base parcer class for base components.
 * @param <T> type ext. Component
 */
public abstract class BaseComponentParser<T extends Component> extends Parser {
    /**
     * constructor for basecomponents parcer.
     * @param newNextParser newNextParser.
     */
    BaseComponentParser(final Parser newNextParser) {
        super(newNextParser);
    }

    /**
     * abstract method for getting child regex.
     * @return regex for child components
     */
    public abstract String getChildRegex();

    /**
     * abstract class for getting child class.
     * @return class of child components
     */
    public abstract Class<T> getChildClass();

    /**
     * method parse for all base components.
     * @param text text
     * @param component component
     */
    @Override
    public void parse(final String text, final Component component) {
        String regex = getChildRegex();
        String[] parseResult = text.split(regex);
        Class<T> childClass = getChildClass();
        List<Component> components = new ArrayList<>();
        for (String str : parseResult) {
            if (childClass != null) {
                Component newComponent =
                        getComponentFactory().createNewComponent(childClass);
                components.add(newComponent);
                super.parse(str, newComponent);
            }
        }
        component.setComponents(components);
    }
}
