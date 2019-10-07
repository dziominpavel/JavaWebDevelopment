package by.dziomin.trade.service;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.impl.UserDaoImpl;
import by.dziomin.trade.entity.User;

import java.util.List;

public class UserService extends AbstractService<User> {

    public List<User> getAllUsers() throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {

            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);

            return userDaoImpl.getAll();
        } catch (DaoException e) {

            throw new ServiceException("get all users error", e);
        }
    }

    public User getUserById(Integer id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getById(id);
        } catch (DaoException e) {

            throw new ServiceException("get user by id error", e);
        }
    }

    public User getUserByLogin(String login) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getUserByLogin(login);
        } catch (DaoException e) {

            throw new ServiceException("get user by login error", e);
        }
    }

    public Integer createUser(User user) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.create(user);
        } catch (DaoException e) {

            throw new ServiceException("create user error", e);
        }
    }

    public boolean deleteUser(Integer id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.delete(id);
        } catch (DaoException e) {

            throw new ServiceException("delete user error", e);
        }
    }

    public boolean updateUser(User user) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.update(user);
        } catch (DaoException e) {

            throw new ServiceException("update user error", e);
        }
    }
}
