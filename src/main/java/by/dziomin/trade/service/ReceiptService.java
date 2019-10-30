package by.dziomin.trade.service;

import by.dziomin.trade.entity.ReceiptEntity;

import java.util.List;

/**
 * Service for receipts
 *
 * @author - Pavel Dziomin
 */
public interface ReceiptService extends Service {

    /**
     * Create new receipt
     *
     * @param receipt receipt to create
     * @return created receipt
     * @throws ServiceException service exception
     */
    ReceiptEntity createReceipt(ReceiptEntity receipt) throws ServiceException;

    /**
     * Ger all receipts
     *
     * @return receipt list
     * @throws ServiceException service exception
     */
    List<ReceiptEntity> getAllReceipts() throws ServiceException;

    /**
     * Get receipt by receipt ID
     * @param receiptId receipt id
     * @return receipt
     */
    ReceiptEntity getReceiptById(Long receiptId) throws ServiceException;
}
