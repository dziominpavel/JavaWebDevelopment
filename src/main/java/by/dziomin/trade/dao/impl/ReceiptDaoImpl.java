package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.AbstractDao;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.ReceiptDao;
import by.dziomin.trade.entity.Receipt;
import by.dziomin.trade.entity.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiptDaoImpl extends AbstractDao implements ReceiptDao {

    private final static String SQL_SELECT_All = "SELECT id,user_id,date," +
            "sum FROM RECEIPT";
    private final static String SQL_SELECT_BY_ID = "SELECT id,user_id,date,sum" +
            " FROM RECEIPT WHERE id = ?";
    private final static String SQL_INSERT = "INSERT INTO RECEIPT (`user_id`, `date`, `sum`) VALUES (?, ?, ?)";
    private final static String SQL_DELETE = "DELETE FROM RECEIPT WHERE id = ?";
    private final static String SQL_UPDATE = "UPDATE RECEIPT SET user_id = ?," +
            " date = ?, sum = ? WHERE id = ?";


    public ReceiptDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    public List<Receipt> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_All);
             ResultSet resultSet = statement.executeQuery()) {
            List<Receipt> receiptList = new ArrayList<>();
            while (resultSet.next()) {
                receiptList.add(mapQueryResult(resultSet));
            }
            return receiptList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Receipt getById(Integer id) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(SQL_SELECT_BY_ID, id);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return mapQueryResult(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public Integer create(final Receipt receipt) throws DaoException {
        Object[] params = new Object[]{receipt.getUser().getId(),
                receipt.getDate(), receipt.getAmount()};
        try (PreparedStatement statement = createPreparedStatement(SQL_INSERT, params)) {
            statement.executeUpdate();
            return getCreatedId(statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(final Integer id) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(SQL_DELETE, id)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(final Receipt receipt) throws DaoException {
        Object[] params = new Object[]{receipt.getUser().getId(),
                receipt.getDate(), receipt.getAmount(), receipt.getId()};
        try (PreparedStatement statement = createPreparedStatement(SQL_UPDATE, params)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Receipt mapQueryResult(final ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        User user = new User();
        Integer userId = resultSet.getInt("user_id");
        user.setId(userId);
        Date date = resultSet.getDate("date");
        BigDecimal amount = resultSet.getBigDecimal("sum"); //todo

        Receipt entity = new Receipt();
        entity.setId(id);
        entity.setUser(user);
        entity.setDate(date);
        entity.setAmount(amount);
        return entity;
    }
}

