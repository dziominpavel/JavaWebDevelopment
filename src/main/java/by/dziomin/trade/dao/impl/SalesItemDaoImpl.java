package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.AbstractDao;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.SalesItemDao;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.Receipt;
import by.dziomin.trade.entity.SalesItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesItemDaoImpl extends AbstractDao implements SalesItemDao {

    private final static String SQL_SELECT_All = "SELECT receipt_id," +
            "product_id, count, sum FROM SALESITEM";
    private final static String SQL_SELECT_BY_ID = "SELECT receipt_id," +
            "product_id, count, sum FROM SALESITEM WHERE id = ?";
    private final static String SQL_INSERT = "INSERT INTO SALESITEM " +
            "(`receipt_id`, `product_id`, `count`, `sum`) VALUES (?," +
            "?, ?, ?)";
    private final static String SQL_DELETE = "DELETE FROM SALESITEM WHERE id = ?";
    private final static String SQL_UPDATE = "UPDATE SALESITEM SET receipt_id= ?," +
            " product_id = ?, count = ?, sum = ? WHERE id = ?";

    public SalesItemDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    public List<SalesItem> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_All);
             ResultSet resultSet = statement.executeQuery()) {
            List<SalesItem> salesItemList = new ArrayList<>();
            while (resultSet.next()) {
                salesItemList.add(mapQueryResult(resultSet));
            }
            return salesItemList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private SalesItem mapQueryResult(final ResultSet resultSet) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setId(resultSet.getInt("receipt_id"));
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        Integer count = resultSet.getInt("count");
        BigDecimal price = resultSet.getBigDecimal("sum"); //todo

        SalesItem entity = new SalesItem();
        entity.setReceipt(receipt);
        entity.setProduct(product);
        entity.setCount(count);
        entity.setPrice(price);
        return entity;
    }

    @Override
    public SalesItem getById(Integer id) throws DaoException {
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
    public Integer create(final SalesItem salesItem) throws DaoException {
        Object[] params = new Object[]{
                salesItem.getReceipt().getId(),
                salesItem.getProduct().getId(), salesItem.getCount(),
                salesItem.getPrice()};
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
    public boolean update(final SalesItem salesItem) throws DaoException {
        Object[] params = new Object[]{salesItem.getReceipt().getId(),
                salesItem.getProduct().getId(), salesItem.getCount(),
                salesItem.getPrice(),salesItem.getId()};
        try (PreparedStatement statement = createPreparedStatement(SQL_UPDATE, params)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

