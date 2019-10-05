package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.UserDaoImpl;
import by.dziomin.trade.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.dziomin.trade.entity.Role.ADMIN;
import static by.dziomin.trade.entity.Role.USER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserDaoImplTest {
    private Connection connection;
    private UserDaoImpl userDaoImpl;

    @Before
    public void getConnection() {
        this.connection = ConnectionPool.getInstance().getConnection();
        this.userDaoImpl = new UserDaoImpl(connection);
    }

    @After
    public void returnConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void testGetAll() throws DaoException {
        List<User> result = userDaoImpl.getAll();
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    public void testGetUserById() throws DaoException {
        User result = userDaoImpl.getById(2);
        assertNotNull(result);
        assertEquals("Petrov", result.getName());
        assertEquals("pe", result.getLogin());
        assertEquals("2222", result.getPassword());
        assertEquals(USER, result.getRole());
    }

    @Test
    public void testGetUserByIdNotFound() throws DaoException {
        User result = userDaoImpl.getById(123);
        assertNull(result);
    }

    @Test
    public void testCreateUser() throws DaoException {
        User user = new User();
//        user.setId(10);
        user.setName("Dziomin");
        user.setLogin("Pavel2");
        user.setPassword("1234");
        user.setRole(ADMIN);

        boolean result = userDaoImpl.create(user);
        assertTrue(result);

        User created = userDaoImpl.getUserByLogin("Pavel2");
        assertNotNull(created);
        assertEquals("Dziomin", created.getName());
        assertEquals("Pavel2", created.getLogin());
        assertEquals("1234", created.getPassword());
        assertEquals(ADMIN, created.getRole());
    }

    @Test
    public void testDeleteUser() throws DaoException {
        boolean result = userDaoImpl.delete(3);
        assertTrue(result);
        User deleted = userDaoImpl.getById(3);
        assertNull(deleted);
    }

    @Test
    public void testUpdateUser() throws DaoException {
        User user = new User();
        user.setId(2);
        user.setName("test");
        user.setPassword("password");
        user.setRole(ADMIN);
        boolean result = userDaoImpl.update(user);
        assertTrue(result);

        User updated = userDaoImpl.getById(2);
        assertEquals("test", updated.getName());
        assertEquals("pe", updated.getLogin());
        assertEquals("password", updated.getPassword());
        assertEquals(ADMIN, updated.getRole());
    }
}
