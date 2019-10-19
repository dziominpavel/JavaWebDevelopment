package by.dziomin.trade.service.impl;

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
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.SalesItem;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.service.AbstractService;
import by.dziomin.trade.service.ReceiptService;
import by.dziomin.trade.service.ServiceException;

import java.util.List;

/**
 * Implementation of Receipt Service
 *
 * @author - Pavel Dziomin
 */
public class ReceiptServiceImpl extends AbstractService implements ReceiptService {

    private static ReceiptService instance;

    private ReceiptServiceImpl() {
    }

    public static ReceiptService getInstance() {
        if (instance == null) {
            instance = new ReceiptServiceImpl();
        }
        return instance;
    }

    @Override
    public ReceiptEntity createReceipt(final ReceiptEntity receipt) throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {
            ReceiptDao receiptDao = new ReceiptDaoImpl(connection);
            SalesItemDao salesItemDao = new SalesItemDaoImpl(connection);
            ProductDao productDao = new ProductDaoImpl(connection);
            UserDao userDao = new UserDaoImpl(connection);

            UserEntity user = userDao.getUserByLogin(receipt.getUser().getLogin());
            receipt.setUser(user);

            Long receiptId = receiptDao.create(receipt);
            ReceiptEntity created = receiptDao.getById(receiptId);

            for (SalesItem salesItem : receipt.getSalesItems()) {
                salesItem.setReceipt(created);
                salesItemDao.create(salesItem);

                ProductEntity product =
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

    @Override
    public List<ReceiptEntity> getAllReceipts() throws ServiceException {
        try (ConnectionPool.ProxyConnection connection = getConnection()) {

            ReceiptDaoImpl receiptDaoImpl = new ReceiptDaoImpl(connection);

            return receiptDaoImpl.getAll();
        } catch (DaoException e) {
            throw new ServiceException("get all users error", e);
        }
    }
}
