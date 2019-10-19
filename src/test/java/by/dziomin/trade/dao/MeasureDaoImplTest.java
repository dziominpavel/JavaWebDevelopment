package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.MeasureDaoImpl;
import by.dziomin.trade.entity.MeasureEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Tests for MeasureDaoImpl
 *
 * @author - Pavel Dziomin
 */
public class MeasureDaoImplTest {
    private Connection connection;
    private MeasureDaoImpl measureDao;

    @Before
    public void getConnection() {
        this.connection = ConnectionPool.getInstance().getConnection();
        this.measureDao = new MeasureDaoImpl(connection);
    }

    @After
    public void returnConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void getMeasureList() throws DaoException {
        List<MeasureEntity> result = measureDao.getAll();
        assertNotNull(result);
        assertEquals(9, result.size());
    }

    @Test
    public void getMeasureById() throws DaoException {
        MeasureEntity result = measureDao.getById(2L);
        assertNotNull(result);
        assertEquals("мешок 100кг", result.getName());
    }

    @Test
    public void createMeasureTest() throws DaoException {
        MeasureEntity entity = new MeasureEntity();
        entity.setName("мешок 5кг");

        Long id = measureDao.create(entity);
        assertNotNull(id);
        MeasureEntity created = measureDao.getById(id);
        assertNotNull(created);
        assertEquals("мешок 5кг", created.getName());
    }

    @Test
    public void deleteMeasureTest() throws DaoException {
        MeasureEntity existing = measureDao.getByName("мешок 5кг");
        assertNotNull(existing);
        measureDao.delete(existing.getId());
        MeasureEntity deleted = measureDao.getByName("мешок 5кг");
        assertNull(deleted);
    }

    @Test
    public void updateMeasureTest() throws DaoException {
        MeasureEntity entity = new MeasureEntity();
        entity.setId(1L);
        entity.setName("мешок 45кг");

        measureDao.update(entity);
        MeasureEntity updated = measureDao.getById(1L);
        assertNotNull(updated);
        assertEquals("мешок 45кг", updated.getName());
    }

    @Test
    public void getByNameTest() throws DaoException {
        MeasureEntity result = measureDao.getByName("шт");
        assertNotNull(result);
        assertEquals("шт", result.getName());
    }
}