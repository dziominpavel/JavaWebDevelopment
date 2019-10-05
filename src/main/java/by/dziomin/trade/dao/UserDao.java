package by.dziomin.trade.dao;

import by.dziomin.trade.entity.User;

public interface UserDao extends BaseDao<User> {

    User getUserByLogin(String login) throws DaoException;

}
