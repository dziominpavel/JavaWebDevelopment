package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.AbstractDao;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.ProductDao;
import by.dziomin.trade.entity.Measure;
import by.dziomin.trade.entity.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends AbstractDao implements ProductDao {

    private final static String SQL_SELECT_All = "SELECT id,name,barcode," +
            "price," +
            "count, measure_id FROM PRODUCTS";
    private final static String SQL_SELECT_BY_ID = "SELECT id,name,barcode,price," +
            "count, measure_id FROM PRODUCTS WHERE id = ?";
    private final static String SQL_SELECT_BY_BARCODE = "SELECT id,name," +
            "barcode,price,count, measure_id FROM PRODUCTS WHERE barcode = ?";
    private final static String SQL_INSERT = "INSERT INTO PRODUCTS (`name`, " +
            "`barcode`, `price`, `count`,`measure_id`) VALUES (?, ?, ?, ?," +
            "?)";
    private final static String SQL_DELETE = "DELETE FROM PRODUCTS WHERE id = ?";
    private final static String SQL_UPDATE = "UPDATE PRODUCTS SET name = ?, barcode " +
            "= ?, price = ?, count = ?, measure_id = ? WHERE id = ?";


    public ProductDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_SELECT_All);
             ResultSet resultSet = statement.executeQuery()) {
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(mapQueryResult(resultSet));
            }
            return productList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Product getById(Integer id) throws DaoException {
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
    public Product getByBarcode(String barcode) throws DaoException {
        try (PreparedStatement statement =
                     createPreparedStatement(SQL_SELECT_BY_BARCODE, barcode);
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
    public Integer create(final Product product) throws DaoException {
        Object[] params = new Object[]{product.getName(),
                product.getBarcode(), product.getPrice(), product.getCount(),
                product.getMeasure().getId()};
        try (PreparedStatement statement = createPreparedStatement(SQL_INSERT, params)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(final Integer id) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(SQL_DELETE,
                id)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(final Product product) throws DaoException {
        Object[] params = new Object[]{product.getName(),
                product.getBarcode(), product.getPrice(), product.getCount(),
                product.getMeasure().getId(), product.getId()};
        try (PreparedStatement statement = createPreparedStatement(SQL_UPDATE,
                params)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Product mapQueryResult(final ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String barcode = resultSet.getString("barcode");
        BigDecimal price = resultSet.getBigDecimal("price");
        Integer count = resultSet.getInt("count");
        Measure measure = new Measure();
        measure.setId(resultSet.getInt("measure_id"));

        Product entity = new Product();
        entity.setId(id);
        entity.setName(name);
        entity.setBarcode(barcode);
        entity.setPrice(price);
        entity.setCount(count);
        entity.setMeasure(measure);
        return entity;
    }
}

