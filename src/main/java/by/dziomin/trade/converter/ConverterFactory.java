package by.dziomin.trade.converter;

import by.dziomin.trade.converter.impl.ProductConverter;
import by.dziomin.trade.converter.impl.UserConverter;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.User;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {
    private static ConverterFactory instance;

    private static Map<Class, Converter> converters;

    private ConverterFactory() {
        converters = new HashMap<>();
        converters.put(Product.class, ProductConverter.getInstance());
        converters.put(User.class, UserConverter.getInstance());
    }

    public static ConverterFactory getInstance() {
        if (instance == null) {
            instance = new ConverterFactory();
        }
        return instance;
    }

    public Converter getConverter(Class cl) {
        return converters.get(cl);
    }
}
