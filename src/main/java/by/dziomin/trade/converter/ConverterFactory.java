package by.dziomin.trade.converter;

import by.dziomin.trade.converter.impl.ProductConverter;
import by.dziomin.trade.converter.user.SessionUserConverter;
import by.dziomin.trade.converter.user.UserConverter;
import by.dziomin.trade.converter.user.UserCreateConverter;
import by.dziomin.trade.converter.user.UserUpdateConverter;
import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.BaseEntity;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.User;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {
    private static ConverterFactory instance;

    private static Map<Class, Map<Class, Converter>> converters;

    private ConverterFactory() {
        converters = new HashMap<>();

        Map<Class, Converter> productConverters = new HashMap<>();
        productConverters.put(ProductDTO.class, ProductConverter.getInstance());
        productConverters.put(ProductUpdateDTO.class, ProductConverter.getInstance());
        productConverters.put(ProductCreateDTO.class, ProductConverter.getInstance());

        Map<Class, Converter> userConverters = new HashMap<>();
        userConverters.put(SessionUserDTO.class,
                SessionUserConverter.getInstance());
        userConverters.put(UserCreateDTO.class,
                UserCreateConverter.getInstance());
        userConverters.put(UserUpdateDTO.class,
                UserUpdateConverter.getInstance());
        userConverters.put(UserDTO.class, UserConverter.getInstance());

        converters.put(Product.class, productConverters);
        converters.put(User.class, userConverters);
    }

    public static ConverterFactory getInstance() {
        if (instance == null) {
            instance = new ConverterFactory();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity, D extends BaseDTO> Converter<T, D>
    getConverter(Class<T> entityClass, Class<D> dtoClass) {
        return converters.get(entityClass).get(dtoClass);
    }
}
