package by.dziomin.trade.dao;

import by.dziomin.trade.entity.ProductEntity;

public interface ProductDao extends BaseDao<ProductEntity> {

    ProductEntity getByBarcode(String barcode) throws DaoException;

}
