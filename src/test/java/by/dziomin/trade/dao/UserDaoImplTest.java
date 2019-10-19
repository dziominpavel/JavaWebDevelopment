package by.dziomin.trade.dao;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.impl.UserDaoImpl;
import by.dziomin.trade.entity.UserEntity;
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
        List<UserEntity> result = userDaoImpl.getAll();
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    public void testGetUserById() throws DaoException {
        UserEntity result = userDaoImpl.getById(2L);
        assertNotNull(result);
        assertEquals("Petrov", result.getName());
        assertEquals("pe", result.getLogin());
        assertEquals("2222", result.getPassword());
        assertEquals(USER, result.getRole());
    }

    @Test
    public void testGetUserByIdNotFound() throws DaoException {
        UserEntity result = userDaoImpl.getById(123L);
        assertNull(result);
    }

    @Test
    public void testCreateUser() throws DaoException {
        UserEntity user = new UserEntity();
        user.setName("Dziomin");
        user.setLogin("Pavel2");
        user.setPassword("1234");
        user.setRole(ADMIN);

        Long result = userDaoImpl.create(user);

        UserEntity created = userDaoImpl.getById(result);
        assertNotNull(created);
        assertEquals("Dziomin", created.getName());
        assertEquals("Pavel2", created.getLogin());
        assertEquals("1234", created.getPassword());
        assertEquals(ADMIN, created.getRole());
    }

    @Test
    public void testDeleteUser() throws DaoException {
        userDaoImpl.delete(3L);
        UserEntity deleted = userDaoImpl.getById(3L);
        assertNull(deleted);
    }

    @Test
    public void testUpdateUser() throws DaoException {
        UserEntity user = new UserEntity();
        user.setId(2L);
        user.setName("test");
        user.setPassword("password");
        user.setRole(ADMIN);
        userDaoImpl.update(user);

        UserEntity updated = userDaoImpl.getById(2L);
        assertEquals("test", updated.getName());
        assertEquals("pe", updated.getLogin());
        assertEquals("password", updated.getPassword());
        assertEquals(ADMIN, updated.getRole());
    }
}
