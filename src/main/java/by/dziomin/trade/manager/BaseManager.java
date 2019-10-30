package by.dziomin.trade.manager;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.entity.BaseEntity;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;
import by.dziomin.trade.validator.ValidatorFactory;

/**
 * Base manager
 *
 * @author - Pavel Dziomin
 */
public abstract class BaseManager {

    @SuppressWarnings("unchecked")
    protected <D extends BaseDTO> void validate(final D dto) throws ValidationException, ServiceException {
        Class<D> dtoClass = (Class<D>) dto.getClass();
        Validator<D> validator = ValidatorFactory.getValidator(dtoClass);
        validator.validate(dto);
    }

    @SuppressWarnings("unchecked")
    protected <T extends BaseEntity, D extends BaseDTO> D convert(T entity, Class<D> classTo) {
        Class<T> classFrom = (Class<T>) entity.getClass();
        Converter<T, D> converter = getConverter(classFrom, classTo);
        return converter.convert(entity);
    }

    @SuppressWarnings("unchecked")
    protected <T extends BaseEntity,
            D extends BaseDTO> T convert(final D dto, final Class<T> classTo) {
        Class<D> classFrom = (Class<D>) dto.getClass();
        Converter<T, D> converter = getConverter(classTo, classFrom);
        return converter.convert(dto);
    }

    @SuppressWarnings("unchecked")
    protected <T extends BaseEntity, D extends BaseDTO> T convert(D dto, T existingEntity, Class<T> classTo) {
        Class<D> classFrom = (Class<D>) dto.getClass();
        Converter<T, D> converter = getConverter(classTo, classFrom);
        return converter.convert(dto, existingEntity);
    }

    protected <T extends BaseEntity, D extends BaseDTO> Converter<T, D> getConverter(Class<T> entityClass, Class<D> dtoClass) {
        return ConverterFactory.getInstance().getConverter(entityClass, dtoClass);
    }
}
