package by.dziomin.trade.manager;

import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

/**
 * Manager for receipt
 *
 * @author - Pavel Dziomin
 */
public interface ReceiptManager extends Manager {
    /**
     * Add sales item to receipt
     *
     * @param barcode        barcode product to add as sales item
     * @param countToAdd     count of product to add
     * @param currentReceipt current receipt
     * @throws ServiceException    service exception
     * @throws ValidationException validation exception
     */
    void addSalesItem(String barcode, final Integer countToAdd, ReceiptDTO currentReceipt) throws ServiceException, ValidationException;

    /**
     * Create receipt
     *
     * @param currentReceipt current receipt
     * @throws ValidationException validation exception
     * @throws ServiceException    service exception
     */
    void createReceipt(ReceiptCreateDTO currentReceipt) throws ValidationException, ServiceException;

    /**
     * Get receipt list
     *
     * @return receipt list
     * @throws ServiceException service exception
     */
    List<ReceiptDTO> getReceipts() throws ServiceException;

    /**
     * Delete sales item from receipt
     *
     * @param productId      product id to delete from receipt
     * @param currentReceipt current receipt
     * @throws ValidationException validation exception
     * @throws ServiceException    service exception
     */
    void deleteSalesItem(Long productId, ReceiptDTO currentReceipt) throws ValidationException, ServiceException;

    /**
     * Get receipt by id
     *
     * @param receiptId receipt id
     * @return receipt
     * @throws ServiceException service exception
     */
    ReceiptDTO getReceipt(Long receiptId) throws ServiceException;
}
