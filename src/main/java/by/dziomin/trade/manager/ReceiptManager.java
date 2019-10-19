package by.dziomin.trade.manager;

import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

public interface ReceiptManager extends Manager {
    void addSalesItem(String barcode, ReceiptDTO currentReceipt) throws ServiceException, ValidationException;

    void createReceipt(ReceiptCreateDTO currentReceipt) throws ValidationException, ServiceException;

    List<ReceiptDTO> getReceipts() throws ServiceException;
}
