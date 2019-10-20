package by.dziomin.trade.service.impl;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.impl.UserDaoImpl;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.service.AbstractService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;

import java.util.List;

/**
 * Implementation of User Service
 *
 * @author - Pavel Dziomin
 */
public class UserServiceImpl extends AbstractService implements UserService {

    private static UserService instance;

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<UserEntity> getAllUsers() throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {

            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);

            return userDaoImpl.getAll();
        } catch (DaoException e) {

            throw new ServiceException("get all users error", e);
        }
    }

    @Override
    public UserEntity getUserById(Long id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getById(id);
        } catch (DaoException e) {
            throw new ServiceException("get user by id error", e);
        }
    }

    @Override
    public UserEntity getUserByLogin(String login) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("get user by login error", e);
        }
    }

    @Override
    public Long createUser(UserEntity user) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.create(user);
        } catch (DaoException e) {
            throw new ServiceException("create user error", e);
        }
    }

    @Override
    public void deleteUser(Long id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            userDaoImpl.delete(id);
        } catch (DaoException e) {
            throw new ServiceException("delete user error", e);
        }
    }

    @Override
    public void updateUser(UserEntity user) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            userDaoImpl.update(user);
        } catch (DaoException e) {
            throw new ServiceException("update user error", e);
        }
    }

    @Override
    public Role getUserRole(final String login) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getRoleByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("get role by login error", e);
        }
    }
}
