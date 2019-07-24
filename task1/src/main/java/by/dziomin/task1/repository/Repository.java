package by.dziomin.task1.repository;

import by.dziomin.task1.entity.Voucher;

import java.util.List;
import java.util.Map;

public interface Repository<T extends Voucher> {
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
    List<T> get(Map<String, Object> parametrs, List<String> orderBy);
}
