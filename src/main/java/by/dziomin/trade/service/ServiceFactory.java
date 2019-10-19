package by.dziomin.trade.service;

import by.dziomin.trade.service.impl.ProductServiceImpl;
import by.dziomin.trade.service.impl.ReceiptServiceImpl;
import by.dziomin.trade.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Service factory
 *
 * @author - Pavel Dziomin
 */
public class ServiceFactory {
    private static Map<Class, Service> serviceMap;

    static {
        serviceMap = new HashMap<>();
        serviceMap.put(UserService.class, UserServiceImpl.getInstance());
        serviceMap.put(ProductService.class, ProductServiceImpl.getInstance());
        serviceMap.put(ReceiptService.class, ReceiptServiceImpl.getInstance());
    }

    private ServiceFactory() {
    }

    /**
     * Ger service instance by its class
     *
     * @param serviceClass service class
     * @param <T>          type of service
     * @return service instance
     */
    @SuppressWarnings("unchecked")
    public static <T extends Service> T getService(Class<T> serviceClass) {
        return (T) serviceMap.get(serviceClass);
    }
}
