package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.SalesItemDaoImpl;
import by.dziomin.trade.entity.SalesItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
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
        assertEquals(1, result.size());
    }

    @Test
    public void getSalesItemById() throws DaoException {
        SalesItem result = salesItemDao.getById(1L);
        assertNotNull(result);
        assertEquals(Long.valueOf(2L), result.getProduct().getId());
        assertEquals(Integer.valueOf(2), result.getCount());
//        BigDecimal expectedPrice = new BigDecimal(65.50);
        BigDecimal expectedPrice = BigDecimal.valueOf(65.50);
        assertEquals(0, expectedPrice.compareTo(result.getPrice()));
//        assertEquals();
    }
}