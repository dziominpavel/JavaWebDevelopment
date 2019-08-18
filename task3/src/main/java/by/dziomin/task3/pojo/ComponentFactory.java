package by.dziomin.task3.pojo;

import by.dziomin.task3.exception.ServiceException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ComponentFactory {

    private static ComponentFactory instance;

    private ComponentFactory() {
    }

    public static ComponentFactory getInstance() {
        if (instance == null) {
            instance = new ComponentFactory();
        }
        return instance;
    }

    public <T> T createNewComponent(Class<T> componentClass) {
        try {
            Constructor<T> constructor =
                    componentClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Internal error", e);
        }
    }
}
