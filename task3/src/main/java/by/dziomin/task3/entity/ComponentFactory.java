package by.dziomin.task3.entity;

import by.dziomin.task3.service.exception.ServiceException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ComponentFactory class.
 */
public final class ComponentFactory {
    /**
     * instance field.
     */
    private static ComponentFactory instance;

    /**
     * default constructor.
     */
    private ComponentFactory() {
    }

    /**
     * get instance method.
     *
     * @return instance.
     */
    public static ComponentFactory getInstance() {
        if (instance == null) {
            instance = new ComponentFactory();
        }
        return instance;
    }

    /**
     * method creates new component.
     *
     * @param componentClass class of
     * @param <T>            needed type to create component.
     * @return needed component.
     */
    public <T> T createNewComponent(final Class<T> componentClass) {
        try {
            Constructor<T> constructor =
                    componentClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Internal error", e);
        }
    }
}
