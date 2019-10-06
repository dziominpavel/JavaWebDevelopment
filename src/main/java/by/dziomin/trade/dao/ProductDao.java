package by.dziomin.trade.dao;

import by.dziomin.trade.entity.Product;

public interface ProductDao extends BaseDao<Product> {

    Product getByBarcode(String barcode) throws DaoException;

}
