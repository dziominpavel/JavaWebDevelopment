package by.dziomin.task1.repository;

import by.dziomin.task1.entity.BaseEntity;

import java.util.HashMap;
import java.util.List;

public interface Repository<T extends BaseEntity> {
    /**
     * add.
     *
     * @param entity entity
     */
    void add(T entity);

    /**
     * delete.
     *
     * @param entity entity
     */
    void delete(T entity);

    /**
     * get.
     *
     * @param parametrs parametrs
     * @param orderBy   orderBy
     * @return List<T>
     */
    List<T> get(HashMap<String, Object> parametrs, List<String> orderBy);
}
