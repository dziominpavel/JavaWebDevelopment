package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.MeasureDaoImpl;
import by.dziomin.trade.entity.Measure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        List<Measure> result = measureDao.getAll();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void getMeasureById() throws DaoException {
        Measure result = measureDao.getById(2);
        assertNotNull(result);
        assertEquals("box", result.getName());
    }
}