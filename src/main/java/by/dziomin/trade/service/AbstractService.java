package by.dziomin.trade.service;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.entity.BaseEntity;

public class AbstractService<T extends BaseEntity> {
    protected ConnectionPool.ProxyConnection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }
}
