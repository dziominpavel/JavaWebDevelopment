package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.SalesItemDao;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.SalesItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implementation for sales items
 *
 * @author - Pavel Dziomin
 */
public class SalesItemDaoImpl extends BaseDaoImpl<SalesItem> implements SalesItemDao {

    private static final String SQL_SELECT_ALL = "SELECT receipt_id," +
            "product_id, count, sum FROM SALESITEM";
    private static final String SQL_SELECT_BY_ID = "SELECT receipt_id," +
            "product_id, count, sum FROM SALESITEM WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO SALESITEM " +
            "(receipt_id, product_id, count, sum) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM SALESITEM WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE SALESITEM SET receipt_id= ?," +
            " product_id = ?, count = ?, sum = ? WHERE id = ?";
    private static final String SQL_SELECT_BY_RECEIPT_ID = "SELECT " +
            "receipt_id,product_id, count, sum FROM SALESITEM WHERE " +
            "receipt_id = ?";

    /**
     * Constructor
     *
     * @param connection db connection
     */
    public SalesItemDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    String getSqlSelectAll() {
        return SQL_SELECT_ALL;
    }

    @Override
    String getSqlSelectById() {
        return SQL_SELECT_BY_ID;
    }

    @Override
    String getSqlInsert() {
        return SQL_INSERT;
    }

    @Override
    String getSqlUpdate() {
        return SQL_UPDATE;
    }

    @Override
    String getSqlDelete() {
        return SQL_DELETE;
    }

    @Override
    Object[] getInsertParams(final SalesItem entity) {
        return new Object[]{entity.getReceipt().getId(),
                entity.getProduct().getId(), entity.getCount(),
                entity.getPrice()};
    }

    @Override
    Object[] getUpdateParams(final SalesItem entity) {
        return new Object[]{entity.getReceipt().getId(),
                entity.getProduct().getId(), entity.getCount(),
                entity.getPrice(), entity.getId()};
    }

    @Override
    public List<SalesItem> getByReceiptId(final Long receiptId) throws DaoException {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(SQL_SELECT_BY_RECEIPT_ID)) {
            setParameters(statement, receiptId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<SalesItem> resultList = new ArrayList<>();
                while (resultSet.next()) {
                    resultList.add(mapQueryResult(resultSet));
                }
                return resultList;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected SalesItem mapQueryResult(final ResultSet resultSet) throws SQLException {
        ReceiptEntity receipt = new ReceiptEntity();
        receipt.setId(resultSet.getLong("receipt_id"));
        ProductEntity product = new ProductEntity();
        product.setId(resultSet.getLong("product_id"));
        Integer count = resultSet.getInt("count");
        BigDecimal price = resultSet.getBigDecimal("sum");

        SalesItem entity = new SalesItem();
        entity.setReceipt(receipt);
        entity.setProduct(product);
        entity.setCount(count);
        entity.setPrice(price);
        return entity;
    }

}

