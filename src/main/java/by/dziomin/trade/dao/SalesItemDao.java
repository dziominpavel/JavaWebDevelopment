package by.dziomin.trade.dao;

import by.dziomin.trade.entity.SalesItem;

import java.util.List;

/**
 * DAO interface for sales items
 *
 * @author - Pavel Dziomin
 */
public interface SalesItemDao extends BaseDao<SalesItem> {

    /**
     * Get sales items by receipt id
     *
     * @param receiptId receipt id
     * @return receipt sales items
     */
    List<SalesItem> getByReceiptId(Long receiptId) throws DaoException;
}
