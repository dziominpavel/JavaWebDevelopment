package by.dziomin.trade.service;

import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;

import java.util.List;

/**
 * Service for users
 *
 * @author - Pavel Dziomin
 */
public interface UserService extends Service {
    /**
     * Get all users
     *
     * @return users list
     * @throws ServiceException service exception
     */
    List<UserEntity> getAllUsers() throws ServiceException;

    /**
     * Get user by id
     *
     * @param id user id
     * @return user
     * @throws ServiceException service exception
     */
    UserEntity getUserById(Long id) throws ServiceException;

    /**
     * Get user by login
     *
     * @param login user login
     * @return user
     * @throws ServiceException service exception
     */
    UserEntity getUserByLogin(String login) throws ServiceException;

    /**
     * Create new user
     *
     * @param user user to create
     * @return created user id
     * @throws ServiceException service exception
     */
    Long createUser(UserEntity user) throws ServiceException;

    /**
     * Delete user by user id
     *
     * @param id user id
     * @throws ServiceException service exception
     */
    void deleteUser(Long id) throws ServiceException;

    /**
     * Update existing user
     *
     * @param user user to update
     * @throws ServiceException service exception
     */
    void updateUser(UserEntity user) throws ServiceException;

    /**
     * Get user role by user login
     *
     * @param login user login
     * @return user role
     */
    Role getUserRole(String login) throws ServiceException;
}

