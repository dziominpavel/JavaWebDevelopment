package by.dziomin.trade.converter;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<T extends BaseEntity, D extends BaseDTO> implements Converter<T, D> {

    @Override
    public List<D> convertEntityList(final List<T> entityList) {
        List<D> dtoList = new ArrayList<>(entityList.size());
        for (T entity : entityList) {
            D dto = convert(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<T> convertDtoList(final List<D> dtoList) {
        List<T> entityList = new ArrayList<>(dtoList.size());
        for (D dto : dtoList) {
            T entity = convert(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public D convert(final T entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T convert(final D dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T convert(final D dto, T existingEntity) {
        throw new UnsupportedOperationException();
    }
}
