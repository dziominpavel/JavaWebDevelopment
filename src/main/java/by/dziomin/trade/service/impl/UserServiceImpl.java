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

import static by.dziomin.trade.util.ErrorMessages.CREATE_USER_ERROR;
import static by.dziomin.trade.util.ErrorMessages.DELETE_USER_ERROR;
import static by.dziomin.trade.util.ErrorMessages.GET_ALL_USERS_ERROR;
import static by.dziomin.trade.util.ErrorMessages.GET_ROLE_BY_LOGIN_ERROR;
import static by.dziomin.trade.util.ErrorMessages.GET_USER_BY_ID_ERROR;
import static by.dziomin.trade.util.ErrorMessages.GET_USER_BY_LOGIN_ERROR;
import static by.dziomin.trade.util.ErrorMessages.UPDATE_USER_ERROR;

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

            throw new ServiceException(GET_ALL_USERS_ERROR, e);
        }
    }

    @Override
    public UserEntity getUserById(Long id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(GET_USER_BY_ID_ERROR, e);
        }
    }

    @Override
    public UserEntity getUserByLogin(String login) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(GET_USER_BY_LOGIN_ERROR, e);
        }
    }

    @Override
    public Long createUser(UserEntity user) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.create(user);
        } catch (DaoException e) {
            throw new ServiceException(CREATE_USER_ERROR, e);
        }
    }

    @Override
    public void deleteUser(Long id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            userDaoImpl.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(DELETE_USER_ERROR, e);
        }
    }

    @Override
    public void updateUser(UserEntity user) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            userDaoImpl.update(user);
        } catch (DaoException e) {
            throw new ServiceException(UPDATE_USER_ERROR, e);
        }
    }

    @Override
    public Role getUserRole(final String login) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            UserDaoImpl userDaoImpl = new UserDaoImpl(connection);
            return userDaoImpl.getRoleByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(GET_ROLE_BY_LOGIN_ERROR, e);
        }
    }
}
