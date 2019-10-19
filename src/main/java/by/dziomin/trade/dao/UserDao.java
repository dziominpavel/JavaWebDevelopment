package by.dziomin.trade.dao;

import by.dziomin.trade.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity> {

    UserEntity getUserByLogin(String login) throws DaoException;

}
