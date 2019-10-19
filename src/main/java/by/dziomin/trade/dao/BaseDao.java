package by.dziomin.trade.dao;

import by.dziomin.trade.entity.BaseEntity;

import java.util.List;

/**
 * Base DAO interface
 *
 * @param <T> entity type
 * @author - Pavel Dziomin
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * Get all entities
     *
     * @return all entities list
     * @throws DaoException dao exception
     */
    List<T> getAll() throws DaoException;

    /**
     * Get entity by id
     *
     * @param id entity id
     * @return entity
     * @throws DaoException dao exception
     */
    T getById(Long id) throws DaoException;

    /**
     * Create entity
     *
     * @param entity entity to create
     * @return created entity id
     * @throws DaoException dao exception
     */
    Long create(T entity) throws DaoException;

    /**
     * Delete existing entity by id
     *
     * @param id entity id
     * @throws DaoException dao exception
     */
    void delete(Long id) throws DaoException;

    /**
     * Update existing entity
     *
     * @param entity entity to update
     * @throws DaoException dao exception
     */
    void update(T entity) throws DaoException;
}
