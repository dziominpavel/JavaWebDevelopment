package by.dziomin.task3.logic.parser;

import by.dziomin.task3.pojo.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComponentParser<T extends Component> extends Parser {

    BaseComponentParser(final Parser newNextParser) {
        super(newNextParser);
    }

    public abstract String getChildRegex();

    public abstract Class<T> getChildClass();

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
