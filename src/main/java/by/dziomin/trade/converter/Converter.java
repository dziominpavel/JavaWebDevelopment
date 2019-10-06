package by.dziomin.trade.converter;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.entity.BaseEntity;

import java.util.List;

public interface Converter<T extends BaseEntity, D extends BaseDTO> {

    D convert(T entity);

    T convert(D dto);

    T convert(D dto, T existingEntity);

    List<D> convertEntityList(List<T> entityList);

    List<T> convertDtoList(List<D> dtoList);

}
