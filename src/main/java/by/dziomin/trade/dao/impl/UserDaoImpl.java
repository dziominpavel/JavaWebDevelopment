package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.UserDao;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO implementation for users
 *
 * @author - Pavel Dziomin
 */
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {

    private static final String SQL_SELECT_ALL = "SELECT id,name,login,password,role " +
            "FROM USER";
    private static final String SQL_SELECT_BY_ID = "SELECT id,name,login,password," +
            "role FROM USER WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO USER (name, " +
            "login, password, role) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_LOGIN = "SELECT id,name,login,password," +
            "role FROM USER WHERE login = ?";
    private static final String SQL_DELETE = "DELETE FROM USER WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE USER SET name = ?, password = ?," +
            " role = ? WHERE id = ?";
    private static final String SQL_SELECT_ROLE_BY_LOGIN = "SELECT role FROM USER WHERE login = ?";

    /**
     * Constructor
     *
     * @param connection db connection
     */
    public UserDaoImpl(final Connection connection) {
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
    Object[] getInsertParams(final UserEntity entity) {
        return new Object[]{entity.getName(), entity.getLogin(),
                entity.getPassword(), entity.getRole().name()};
    }

    @Override
    Object[] getUpdateParams(final UserEntity entity) {
        return new Object[]{entity.getName(), entity.getPassword(),
                entity.getRole().name(), entity.getId()};
    }


    @Override
    public UserEntity getUserByLogin(final String login) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_BY_LOGIN)) {
            setParameters(statement, login);
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
    public Role getRoleByLogin(final String login) throws DaoException {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(SQL_SELECT_ROLE_BY_LOGIN)) {
            setParameters(statement, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Role.valueOf(resultSet.getString("role").toUpperCase());
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    protected UserEntity mapQueryResult(final ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        Role role = Role.valueOf(resultSet.getString("role").toUpperCase());

        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setLogin(login);
        entity.setPassword(password);
        entity.setRole(role);
        return entity;
    }
}
