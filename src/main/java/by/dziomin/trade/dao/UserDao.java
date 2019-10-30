package by.dziomin.trade.dao;

import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;

/**
 * DAO interface for users
 *
 * @author - Pavel Dziomin
 */
public interface UserDao extends BaseDao<UserEntity> {

    /**
     * Get user by login
     * @param login user login
     * @return user
     * @throws DaoException dao exception
     */
    UserEntity getUserByLogin(String login) throws DaoException;

    /**
     * Ger user role by login
     * @param login user login
     * @return user role
     * @throws DaoException dao exception
     */
    Role getRoleByLogin(String login) throws DaoException;
}
