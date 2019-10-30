package by.dziomin.trade.converter;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.entity.BaseEntity;

import java.util.List;

/**
 * Converter entity to Dto & dto to entity
 *
 * @param <T> Entity
 * @param <D> Dto
 */
public interface Converter<T extends BaseEntity, D extends BaseDTO> {
    /**
     * Converts from entity to Dto.
     *
     * @param entity entity for convert/
     * @return dto
     */
    D convert(T entity);

    /**
     * Converts from dto to entity.
     *
     * @param dto dto
     * @return entity
     */
    T convert(D dto);

    /**
     * Converts from dto to Entity.
     *
     * @param dto
     * @param existingEntity
     * @return
     */
    T convert(D dto, T existingEntity);

    List<D> convertEntityList(List<T> entityList);

    List<T> convertDtoList(List<D> dtoList);

}
