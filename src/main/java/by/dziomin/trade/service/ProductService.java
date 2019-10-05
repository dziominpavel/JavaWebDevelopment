package by.dziomin.trade.service;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.MeasureDao;
import by.dziomin.trade.dao.ProductDao;
import by.dziomin.trade.dao.impl.MeasureDaoImpl;
import by.dziomin.trade.dao.impl.ProductDaoImpl;
import by.dziomin.trade.entity.Measure;
import by.dziomin.trade.entity.Product;

import java.util.List;

public class ProductService extends AbstractService<Product> {

    public List<Product> getAllProducts() throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {

            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);
            List<Product> productList = productDao.getAll();
            for (Product product : productList) {
                Measure measure =
                        measureDao.getById(product.getMeasure().getId());
                product.setMeasure(measure);
            }
            return productList;
        } catch (DaoException e) {

            throw new ServiceException("get all users error", e);
        }
    }

    public Product getProductById(Integer id) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            ProductDao productDao = new ProductDaoImpl(connection);
            MeasureDao measureDao = new MeasureDaoImpl(connection);
            Product product = productDao.getById(id);
            Measure measure =
                    measureDao.getById(product.getMeasure().getId());
            product.setMeasure(measure);
            return product;
        } catch (DaoException e) {
            throw new ServiceException("get user by id error", e);
        }
    }
}
