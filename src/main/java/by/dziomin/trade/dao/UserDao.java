package by.dziomin.trade.dao;

import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity> {

    UserEntity getUserByLogin(String login) throws DaoException;

    Role getRoleByLogin(String login) throws DaoException;
}
