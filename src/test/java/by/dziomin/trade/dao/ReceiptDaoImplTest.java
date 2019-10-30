package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.ReceiptDaoImpl;
import by.dziomin.trade.entity.ReceiptEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReceiptDaoImplTest {
    private Connection connection;
    private ReceiptDaoImpl receiptDao;

    @Before
    public void getConnection() {
        this.connection = ConnectionPool.getInstance().getConnection();
        this.receiptDao = new ReceiptDaoImpl(connection);
    }

    @After
    public void returnConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void getReceiptListTest() throws DaoException {
        List<ReceiptEntity> result = receiptDao.getAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void getReceiptByIdTest() throws DaoException {
        ReceiptEntity result = receiptDao.getById(1L);
        assertNotNull(result);
    }

    @Test
    public void createTest() throws DaoException {
        ReceiptEntity result = receiptDao.getById(1L);
        assertNotNull(result);
    }

}