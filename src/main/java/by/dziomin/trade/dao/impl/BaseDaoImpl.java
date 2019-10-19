package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.AbstractDao;
import by.dziomin.trade.dao.BaseDao;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.entity.BaseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Base DAO implementation
 *
 * @param <T> entity type
 * @author - Pavel Dziomin
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends AbstractDao implements BaseDao<T> {

    /**
     * Constructor
     *
     * @param connection db connection
     */
    BaseDaoImpl(final Connection connection) {
        super(connection);
    }

    /**
     * Get select query
     *
     * @return select query string
     */
    abstract String getSqlSelectAll();

    /**
     * Get select by id query
     *
     * @return select by id query string
     */
    abstract String getSqlSelectById();

    /**
     * Get insert query
     *
     * @return insert query string
     */
    abstract String getSqlInsert();

    /**
     * Get update query string
     *
     * @return update query string
     */
    abstract String getSqlUpdate();

    /**
     * Get delete query
     *
     * @return delete query string
     */
    abstract String getSqlDelete();

    /**
     * Get insert query params
     *
     * @param entity entity to insert
     * @return insert params
     */
    abstract Object[] getInsertParams(T entity);

    /**
     * Get update query params
     *
     * @param entity entity to update
     * @return update params
     */
    abstract Object[] getUpdateParams(T entity);

    /**
     * Map query result to entity
     *
     * @param resultSet result set
     * @return result entity
     * @throws SQLException sql exception
     */
    abstract T mapQueryResult(ResultSet resultSet) throws SQLException;

    @Override
    public List<T> getAll() throws DaoException {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(getSqlSelectAll());
             ResultSet resultSet = statement.executeQuery()) {
            List<T> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(mapQueryResult(resultSet));
            }
            return resultList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public T getById(Long id) throws DaoException {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(getSqlSelectById())) {
            setParameters(statement, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapQueryResult(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public Long create(T entity) throws DaoException {
        Object[] params = getInsertParams(entity);
        try (PreparedStatement statement = getConnection().prepareStatement(getSqlInsert(),
                RETURN_GENERATED_KEYS)) {

            setParameters(statement, params);
            statement.executeUpdate();
            return getCreatedId(statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(final T entity) throws DaoException {
        Object[] params = getUpdateParams(entity);
        try (PreparedStatement statement =
                     getConnection().prepareStatement(getSqlUpdate())) {
            setParameters(statement, params);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(final Long id) throws DaoException {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(getSqlDelete())) {
            setParameters(statement, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
