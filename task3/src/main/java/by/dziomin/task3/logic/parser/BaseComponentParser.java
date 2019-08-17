package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComponentParser<T extends Component> extends Parser {

    public abstract String getChildRegex();

    public abstract Class<T> getChildClass();

    BaseComponentParser(final Parser newNextParser) {
        super(newNextParser);
    }

    @Override
    public void parse(final String text, final Component component) {
        String regex = getChildRegex();
        String[] parseResult = text.split(regex);
        Class<T> childClass = getChildClass();
        List<Component> components = new ArrayList<>();
        for (String str : parseResult) {
            Component newComponent =
                    getComponentFactory().getNewComponent(childClass);
            components.add(newComponent);
            super.parse(str, newComponent);
        }
        component.setComponents(components);
    }
}
