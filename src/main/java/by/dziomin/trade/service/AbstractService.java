package by.dziomin.trade.service;

import by.dziomin.trade.connection.ConnectionPool;

/**
 * Abstract service
 *
 * @author - Pavel Dziomin
 */
public class AbstractService {

    /**
     * Provide proxy connection for transaction from connection pool
     *
     * @return db connection
     */
    protected ConnectionPool.ProxyConnection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }
}
