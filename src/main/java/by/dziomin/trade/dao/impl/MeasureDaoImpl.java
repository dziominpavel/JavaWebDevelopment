package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.AbstractDao;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.MeasureDao;
import by.dziomin.trade.entity.Measure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeasureDaoImpl extends AbstractDao implements MeasureDao {

    private final static String SQL_SELECT_All = "SELECT id,name FROM MEASURE";
    private final static String SQL_SELECT_BY_ID = "SELECT id,name FROM MEASURE WHERE id = ?";
    private final static String SQL_SELECT_BY_NAME = "SELECT id,name FROM " +
            "MEASURE WHERE name = ?";
    private final static String SQL_INSERT = "INSERT INTO MEASURE (`name`) VALUES (?)";
    private final static String SQL_DELETE = "DELETE FROM MEASURE WHERE id = ?";
    private final static String SQL_UPDATE = "UPDATE MEASURE SET name = ? WHERE id = ?";


    public MeasureDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    public List<Measure> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_All);
             ResultSet resultSet = statement.executeQuery()) {
            List<Measure> measureList = new ArrayList<>();
            while (resultSet.next()) {
                measureList.add(mapQueryResult(resultSet));
            }
            return measureList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Measure getById(Integer id) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(SQL_SELECT_BY_ID, id);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return mapQueryResult(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public Measure getByName(String name) throws DaoException {
        try (PreparedStatement statement =
                     createPreparedStatement(SQL_SELECT_BY_NAME, name);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return mapQueryResult(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public Integer create(final Measure measure) throws DaoException {
        Object[] params = new Object[]{measure.getName()};
        try (PreparedStatement statement = createPreparedStatement(SQL_INSERT, params)) {
            statement.executeUpdate();
            return getCreatedId(statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(final Integer id) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(SQL_DELETE, id)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(final Measure measure) throws DaoException {
        Object[] params = new Object[]{measure.getName(), measure.getId()};
        try (PreparedStatement statement = createPreparedStatement(SQL_UPDATE, params)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Measure mapQueryResult(final ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        Measure entity = new Measure();
        entity.setId(id);
        entity.setName(name);
        return entity;
    }
}

