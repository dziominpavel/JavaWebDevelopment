package by.dziomin.trade.dao;

import by.dziomin.trade.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    List<T> getAll() throws DaoException;

    T getById(Integer id) throws DaoException;

    Integer create(T entity) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    boolean update(T entity) throws DaoException;
}
