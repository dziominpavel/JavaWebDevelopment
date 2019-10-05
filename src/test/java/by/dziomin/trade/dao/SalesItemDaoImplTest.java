package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.SalesItemDaoImpl;
import by.dziomin.trade.entity.SalesItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SalesItemDaoImplTest {
    private Connection connection;
    private SalesItemDaoImpl salesItemDao;

    @Before
    public void getConnection() {
        this.connection = ConnectionPool.getInstance().getConnection();
        this.salesItemDao = new SalesItemDaoImpl(connection);
    }

    @After
    public void returnConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void getSalesItemList() throws DaoException {
        List<SalesItem> result = salesItemDao.getAll();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Ignore
    @Test
    public void getSalesItemById() throws DaoException {
        SalesItem result = salesItemDao.getById(1); //todo
        assertNotNull(result);
        //assertEquals(250, result.getPrice(), 1);
    }
}