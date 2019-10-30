package by.dziomin.trade.manager;

import by.dziomin.trade.manager.impl.ProductManagerImpl;
import by.dziomin.trade.manager.impl.ReceiptManagerImpl;
import by.dziomin.trade.manager.impl.UserManagerImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Manager factory
 *
 * @author - Pavel Dziomin
 */
public final class ManagerFactory {

    private static Map<Class, Manager> managerMap;

    static {
        managerMap = new HashMap<>();
        managerMap.put(UserManager.class, UserManagerImpl.getInstance());
        managerMap.put(ProductManager.class, ProductManagerImpl.getInstance());
        managerMap.put(ReceiptManager.class, ReceiptManagerImpl.getInstance());
    }

    private ManagerFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends Manager> T getManager(Class<T> mgrClass) {
        return (T) managerMap.get(mgrClass);
    }
}
