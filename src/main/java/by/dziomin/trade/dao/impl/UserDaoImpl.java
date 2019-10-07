package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.AbstractDao;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.UserDao;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {

    final static String SQL_SELECT_All = "SELECT id,name,login,password,role " +
            "FROM USER";
    final static String SQL_SELECT_BY_ID = "SELECT id,name,login,password," +
            "role FROM USER WHERE id = ?";
    final static String SQL_INSERT = "INSERT INTO USER (`name`, " +
            "`login`, `password`, `role`) VALUES (?, ?, ?, ?)";
    final static String SQL_SELECT_BY_LOGIN = "SELECT id,name,login,password," +
            "role FROM USER WHERE login = ?";
    final static String SQL_DELETE = "DELETE FROM USER WHERE id = ?";
    final static String SQL_UPDATE = "UPDATE USER SET name = ?, password = ?," +
            " role = ? WHERE id = ?";

    public UserDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    public List<User> getAll() throws DaoException {
//
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_All);
             ResultSet resultSet = statement.executeQuery()) {
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                userList.add(mapQueryResult(resultSet));
            }
            return userList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User mapQueryResult(final ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        Role role = Role.valueOf(resultSet.getString("role").toUpperCase());

        User entity = new User();
        entity.setId(id);
        entity.setName(name);
        entity.setLogin(login);
        entity.setPassword(password);
        entity.setRole(role);
        return entity;
    }

    @Override
    public User getById(Integer id) throws DaoException {
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
    public Integer create(final User user) throws DaoException {

        Object[] params = new Object[]{user.getName(),
                user.getLogin(), user.getPassword(), user.getRole().name()};
        try (PreparedStatement statement = createPreparedStatement(SQL_INSERT, params)) {
            return statement.executeUpdate();
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
    public User getUserByLogin(final String login) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(SQL_SELECT_BY_LOGIN,
                login);
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
    public boolean update(final User user) throws DaoException {

        Object[] params = new Object[]{user.getName(), user.getPassword(),
                user.getRole().name(), user.getId()};
        try (PreparedStatement statement = createPreparedStatement(SQL_UPDATE, params)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
