package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.MeasureDao;
import by.dziomin.trade.entity.MeasureEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO implementation for Measures
 *
 * @author - Pavel Dziomin
 */
public class MeasureDaoImpl extends BaseDaoImpl<MeasureEntity> implements MeasureDao {

    private static final String SQL_SELECT_ALL = "SELECT id,name FROM MEASURE";
    private static final String SQL_SELECT_BY_ID = "SELECT id,name FROM MEASURE WHERE id = ?";
    private static final String SQL_SELECT_BY_NAME = "SELECT id, name FROM " +
            "MEASURE WHERE name = ?";
    private static final String SQL_INSERT = "INSERT INTO MEASURE (name) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM MEASURE WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE MEASURE SET name = ? WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection db connection
     */
    public MeasureDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    String getSqlSelectAll() {
        return SQL_SELECT_ALL;
    }


    @Override
    String getSqlSelectById() {
        return SQL_SELECT_BY_ID;
    }

    @Override
    String getSqlInsert() {
        return SQL_INSERT;
    }

    @Override
    String getSqlUpdate() {
        return SQL_UPDATE;
    }

    @Override
    String getSqlDelete() {
        return SQL_DELETE;
    }

    @Override
    Object[] getInsertParams(final MeasureEntity entity) {
        return new Object[]{entity.getName()};
    }

    @Override
    Object[] getUpdateParams(final MeasureEntity entity) {
        return new Object[]{entity.getName(), entity.getId()};
    }

    @Override
    public MeasureEntity getByName(String name) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_BY_NAME)) {
            setParameters(statement, name);
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
    protected MeasureEntity mapQueryResult(final ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");

        MeasureEntity entity = new MeasureEntity();
        entity.setId(id);
        entity.setName(name);
        return entity;
    }
}

