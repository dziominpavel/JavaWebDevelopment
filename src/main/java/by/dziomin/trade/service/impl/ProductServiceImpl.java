package by.dziomin.trade.service.impl;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.MeasureDao;
import by.dziomin.trade.dao.ProductDao;
import by.dziomin.trade.dao.impl.MeasureDaoImpl;
import by.dziomin.trade.dao.impl.ProductDaoImpl;
import by.dziomin.trade.entity.MeasureEntity;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.service.AbstractService;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;

import java.sql.SQLException;
import java.util.List;

import static by.dziomin.trade.util.ErrorMessages.GET_ALL_USERS_ERROR;
import static by.dziomin.trade.util.ErrorMessages.GET_PRODUCT_BY_BARCODE_ERROR;
import static by.dziomin.trade.util.ErrorMessages.GET_PRODUCT_BY_ID_ERROR;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_CREATE_ERROR;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_DATA_ERROR;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_NOT_FOUND;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_UPDATE_ERROR;
import static by.dziomin.trade.util.ErrorMessages.SEARCH_PRODUCT_ERROR;

/**
 * Implementation of Product Service
 *
 * @author - Pavel Dziomin
 */
public class ProductServiceImpl extends AbstractService implements ProductService {

    private static ProductService instance;

    private ProductServiceImpl() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public List<ProductEntity> getAllProducts() throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {

            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);
            List<ProductEntity> productList = productDao.getAll();
            for (ProductEntity product : productList) {
                MeasureEntity measure =
                        measureDao.getById(product.getMeasure().getId());
                product.setMeasure(measure);
            }
            return productList;
        } catch (DaoException e) {

            throw new ServiceException(GET_ALL_USERS_ERROR, e);
        }
    }

    @Override
    public ProductEntity getProductById(Long id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);
            ProductEntity product = productDao.getById(id);
            MeasureEntity measure =
                    measureDao.getById(product.getMeasure().getId());
            product.setMeasure(measure);
            return product;
        } catch (DaoException e) {
            throw new ServiceException(GET_PRODUCT_BY_ID_ERROR, e);
        }
    }

    @Override
    public ProductEntity getProductByBarcode(String barcode) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);
            ProductEntity product = productDao.getByBarcode(barcode);
            if (product != null) {
                MeasureEntity measure =
                        measureDao.getById(product.getMeasure().getId());
                product.setMeasure(measure);
            }
            return product;
        } catch (DaoException e) {
            throw new ServiceException(GET_PRODUCT_BY_BARCODE_ERROR, e);
        }
    }

    @Override
    public void updateProduct(final ProductEntity product) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            connection.setAutoCommit(false);
            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);

            MeasureEntity measure =
                    measureDao.getByName(product.getMeasure().getName());
            if (measure == null) {
                //create measure if not exist
                measureDao.create(product.getMeasure());
                measure = measureDao.getByName(product.getMeasure().getName());
                //throw new SQLException("Test transaction");
            }
            product.setMeasure(measure);
            productDao.update(product);
            connection.commit();
        } catch (DaoException | SQLException e) {
            throw new ServiceException(PRODUCT_UPDATE_ERROR, e);
        }
    }

    @Override
    public void createProduct(final ProductEntity product) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            connection.setAutoCommit(false);
            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);

            MeasureEntity measure =
                    measureDao.getByName(product.getMeasure().getName());
            if (measure == null) {
                //create measure if not exist
                measureDao.create(product.getMeasure());
                measure = measureDao.getByName(product.getMeasure().getName());
            }
            product.setMeasure(measure);
            productDao.create(product);
            connection.commit();
        } catch (DaoException | SQLException e) {
            throw new ServiceException(PRODUCT_CREATE_ERROR, e);
        }
    }

    @Override
    public void deleteProduct(final Long productId) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            ProductDao productDao = new ProductDaoImpl(connection);
            ProductEntity product = productDao.getById(productId);
            if (product == null) {
                throw new ServiceException(PRODUCT_NOT_FOUND);
            }
            productDao.delete(productId);
        } catch (DaoException e) {
            throw new ServiceException(PRODUCT_DATA_ERROR, e);
        }
    }

    @Override
    public List<ProductEntity> searchProducts(final String text) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {

            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);
            List<ProductEntity> productList = productDao.search(text);
            for (ProductEntity product : productList) {
                MeasureEntity measure =
                        measureDao.getById(product.getMeasure().getId());
                product.setMeasure(measure);
            }
            return productList;
        } catch (DaoException e) {
            throw new ServiceException(SEARCH_PRODUCT_ERROR, e);
        }
    }
}
