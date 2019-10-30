package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.ProductDaoImpl;
import by.dziomin.trade.entity.MeasureEntity;
import by.dziomin.trade.entity.ProductEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Tests for ProductDaoImpl
 *
 * @author - Pavel Dziomin
 */
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
        List<ProductEntity> result = productDao.getAll();
        assertNotNull(result);
        assertEquals(13, result.size());
    }

    @Test
    public void testGetProductById() throws DaoException {
        ProductEntity result = productDao.getById(1L);
        assertNotNull(result);
        assertEquals("Шпатлевка Ceresit", result.getName());
    }

    @Test
    public void createProductTest() throws DaoException {
        ProductEntity entity = new ProductEntity();
        entity.setName("Гвозди 5х60");
        MeasureEntity measure = new MeasureEntity();
        measure.setId(6L);
        entity.setMeasure(measure);
        entity.setBarcode("4447");
        entity.setCount(40);
        BigDecimal price = BigDecimal.valueOf(45.5);
        entity.setPrice(price);

        Long id = productDao.create(entity);
        assertNotNull(id);
        ProductEntity created = productDao.getById(id);
        assertNotNull(created);
        assertEquals("Гвозди 5х60", created.getName());
        assertEquals(Long.valueOf(6), created.getMeasure().getId());
        assertEquals("4447", created.getBarcode());
        assertEquals(Integer.valueOf(40), created.getCount());
        assertEquals(0, price.compareTo(created.getPrice()));
    }

    @Test
    public void deleteProductTest() throws DaoException {
        ProductEntity existing = productDao.getByBarcode("4447");
        assertNotNull(existing);
        productDao.delete(existing.getId());
        ProductEntity deleted = productDao.getByBarcode("4447");
        assertNull(deleted);
    }

    @Test
    public void updateProductTest() throws DaoException {
        ProductEntity entity = new ProductEntity();
        entity.setId(10L);
        entity.setName("Гвозди 5х70");
        MeasureEntity measure = new MeasureEntity();
        measure.setId(6L);
        entity.setMeasure(measure);
        entity.setCount(50);
        BigDecimal price = BigDecimal.valueOf(50.5);
        entity.setPrice(price);

        productDao.update(entity);
        ProductEntity updated = productDao.getById(10L);
        assertEquals("Гвозди 5х70", updated.getName());
        assertEquals(Long.valueOf(6), updated.getMeasure().getId());
        assertEquals("5556", updated.getBarcode());
        assertEquals(Integer.valueOf(50), updated.getCount());
        assertEquals(0, price.compareTo(updated.getPrice()));
    }

    @Test
    public void getByBarcodeTest() throws DaoException {
        ProductEntity result = productDao.getByBarcode("5556");
        assertNotNull(result);
        assertEquals("5556", result.getBarcode());
    }
}