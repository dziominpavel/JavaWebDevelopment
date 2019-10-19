package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.ProductDao;
import by.dziomin.trade.entity.MeasureEntity;
import by.dziomin.trade.entity.ProductEntity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO implementation for products
 *
 * @author - Pavel Dziomin
 */
public class ProductDaoImpl extends BaseDaoImpl<ProductEntity> implements ProductDao {

    private static final String SQL_SELECT_ALL = "SELECT id,name,barcode," +
            "price, count, measure_id FROM PRODUCTS ORDER BY barcode";
    private static final String SQL_SELECT_BY_ID = "SELECT id,name,barcode,price," +
            "count, measure_id FROM PRODUCTS WHERE id = ?";
    private static final String SQL_SELECT_BY_BARCODE = "SELECT id,name," +
            "barcode,price,count, measure_id FROM PRODUCTS WHERE barcode = ?";
    private static final String SQL_INSERT = "INSERT INTO PRODUCTS (name, " +
            "barcode, price, count, measure_id) VALUES (?, ?, ?, ?," +
            "?)";
    private static final String SQL_DELETE = "DELETE FROM PRODUCTS WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE PRODUCTS SET name = ?, " +
            " price = ?, count = ?, measure_id = ? WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection db connection
     */
    public ProductDaoImpl(final Connection connection) {
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
    Object[] getInsertParams(final ProductEntity entity) {
        return new Object[]{entity.getName(),
                entity.getBarcode(), entity.getPrice(), entity.getCount(),
                entity.getMeasure().getId()};
    }

    @Override
    Object[] getUpdateParams(final ProductEntity entity) {
        return new Object[]{entity.getName(), entity.getPrice(),
                entity.getCount(), entity.getMeasure().getId(), entity.getId()};
    }

    @Override
    public ProductEntity getByBarcode(String barcode) throws DaoException {
        try (PreparedStatement statement =
                     getConnection().prepareStatement(SQL_SELECT_BY_BARCODE)) {
            setParameters(statement, barcode);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapQueryResult(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    protected ProductEntity mapQueryResult(final ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String barcode = resultSet.getString("barcode");
        BigDecimal price = resultSet.getBigDecimal("price");
        Integer count = resultSet.getInt("count");
        MeasureEntity measure = new MeasureEntity();
        measure.setId(resultSet.getLong("measure_id"));

        ProductEntity entity = new ProductEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setBarcode(barcode);
        entity.setPrice(price);
        entity.setCount(count);
        entity.setMeasure(measure);
        return entity;
    }
}

