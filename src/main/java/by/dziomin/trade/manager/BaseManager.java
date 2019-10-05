package by.dziomin.trade.manager;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.entity.BaseEntity;

public abstract class BaseManager {

    protected <T extends BaseEntity, D extends BaseDTO> Converter<T, D> getConverter(Class entityClass, Class dtoClass) {
        return ConverterFactory.getInstance().getConverter(entityClass);
    }
}
