package by.dziomin.trade.manager;

import by.dziomin.trade.manager.impl.ProductManagerImpl;
import by.dziomin.trade.manager.impl.UserManagerImpl;

import java.util.HashMap;
import java.util.Map;

public final class ManagerFactory {

    private static Map<Class, Manager> managerMap;

    static {
        managerMap = new HashMap<>();
        managerMap.put(UserManager.class, UserManagerImpl.getInstance());
        managerMap.put(ProductManager.class, ProductManagerImpl.getInstance());
    }

    private ManagerFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends Manager> T getManager(Class<T> mgrClass) {
        return (T) managerMap.get(mgrClass);
    }
}
