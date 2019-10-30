package by.dziomin.trade.dao;

import by.dziomin.trade.entity.ProductEntity;

import java.util.List;

/**
 * DAO interface for products
 *
 * @author - Pavel Dziomin
 */
public interface ProductDao extends BaseDao<ProductEntity> {

    /**
     * Get product by barcode
     * @param barcode product barcode
     * @return product
     * @throws DaoException dao exception
     */
    ProductEntity getByBarcode(String barcode) throws DaoException;

    /**
     * Search product by barcode or product name
     * @param text search text
     * @return product list
     * @throws DaoException dao exception
     */
    List<ProductEntity> search(String text) throws DaoException;
}
