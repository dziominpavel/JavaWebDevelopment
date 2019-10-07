package by.dziomin.trade.service;

import by.dziomin.trade.connection.ConnectionPool;
import by.dziomin.trade.dao.DaoException;
import by.dziomin.trade.dao.ProductDao;
import by.dziomin.trade.dao.ReceiptDao;
import by.dziomin.trade.dao.SalesItemDao;
import by.dziomin.trade.dao.UserDao;
import by.dziomin.trade.dao.impl.ProductDaoImpl;
import by.dziomin.trade.dao.impl.ReceiptDaoImpl;
import by.dziomin.trade.dao.impl.SalesItemDaoImpl;
import by.dziomin.trade.dao.impl.UserDaoImpl;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.Receipt;
import by.dziomin.trade.entity.SalesItem;
import by.dziomin.trade.entity.User;

public class ReceiptService extends AbstractService<Receipt> {

    public Receipt createReceipt(final Receipt receipt) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            ReceiptDao receiptDao = new ReceiptDaoImpl(connection);
            SalesItemDao salesItemDao = new SalesItemDaoImpl(connection);
            ProductDao productDao = new ProductDaoImpl(connection);
            UserDao userDao = new UserDaoImpl(connection);

            User user = userDao.getUserByLogin(receipt.getUser().getLogin());
            receipt.setUser(user);

            Integer receiptId = receiptDao.create(receipt);
            Receipt created = receiptDao.getById(receiptId);

            for (SalesItem salesItem : receipt.getSalesItems()) {
                salesItem.setReceipt(created);
                salesItemDao.create(salesItem);

                Product product =
                        productDao.getById(salesItem.getProduct().getId());
                Integer countInStock =
                        product.getCount() - salesItem.getCount();
                product.setCount(countInStock);
                productDao.update(product);
            }
            return created;
        } catch (DaoException e) {
            throw new ServiceException("Product create error", e);
        }
    }
}
