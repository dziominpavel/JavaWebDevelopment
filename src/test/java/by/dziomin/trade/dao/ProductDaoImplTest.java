package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.ProductDaoImpl;
import by.dziomin.trade.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductDaoImplTest {
    private Connection connection;
    private ProductDaoImpl productDao;

    @Before
    public void getConnection() {
        this.connection = ConnectionPool.getInstance().getConnection();
        this.productDao = new ProductDaoImpl(connection);
    }

    @After
    public void returnConnection() throws SQLException {
        connection.close();
    }


    @Test
    public void testGetAll() throws DaoException {
        List<Product> result = productDao.getAll();
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    public void testGetProductById() throws DaoException {
        Product result = productDao.getById(3);
        assertNotNull(result);
        assertEquals("snickers", result.getName());
    }

}