package by.dziomin.trade.manager.impl;

import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.Receipt;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.ReceiptManager;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ReceiptService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiptManagerImpl extends BaseManager implements ReceiptManager {
    private static ReceiptManager instance;

    private ReceiptManagerImpl() {
    }

    public static ReceiptManager getInstance() {
        if (instance == null) {
            instance = new ReceiptManagerImpl();
        }
        return instance;
    }

    @Override
    public void addSalesItem(final String barcode, final ReceiptDTO currentReceipt) throws ServiceException, ValidationException {
        ProductService service = new ProductService();
        Product product = service.getProductByBarcode(barcode);
        if (product == null) {
            throw new ValidationException("PRODUCT_NOT_FOUND");
        }

        ProductDTO productDTO = convert(product, ProductDTO.class);
        addSalesItem(currentReceipt, productDTO);
    }

    @Override
    public void createReceipt(final ReceiptCreateDTO currentReceipt) throws ValidationException, ServiceException {
        validate(currentReceipt);
        Receipt receipt = convert(currentReceipt, Receipt.class);
        ReceiptService receiptService = new ReceiptService();
        Receipt created = receiptService.createReceipt(receipt);
    }

    private void addSalesItem(ReceiptDTO currentReceipt, ProductDTO product) throws ValidationException {
        List<SalesItemDTO> salesItems = currentReceipt.getSalesItems();
        if (salesItems == null) {
            salesItems = new ArrayList<>();
            currentReceipt.setSalesItems(salesItems);
        }

        SalesItemDTO salesItem = findSalesItemInReceipt(salesItems,
                product.getBarcode());
        salesItem.setProduct(product);

        calculateSalesItem(salesItem);
        calculateReceipt(currentReceipt);
    }

    private void calculateReceipt(final ReceiptDTO currentReceipt) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (SalesItemDTO salesItem : currentReceipt.getSalesItems()) {
            totalPrice = totalPrice.add(salesItem.getTotalPrice());
        }
        currentReceipt.setTotalPrice(totalPrice);
    }

    private void calculateSalesItem(final SalesItemDTO salesItem) throws ValidationException {
        Integer count = salesItem.getCount();
        if (count == null) {
            count = 1;
        } else {
            count = count + 1;
        }
        if (count > salesItem.getProduct().getCount()) {
            throw new ValidationException("OUT_OF_STOCK");
        }
        salesItem.setCount(count);

        BigDecimal price = salesItem.getProduct().getPrice();
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(count));
        salesItem.setTotalPrice(totalPrice);
    }

    private SalesItemDTO findSalesItemInReceipt(final List<SalesItemDTO> salesItems, final String barcode) {
        for (SalesItemDTO item : salesItems) {
            if (barcode.equals(item.getProduct().getBarcode())) {
                return item;
            }
        }
        //create new if not found
        SalesItemDTO salesItem = new SalesItemDTO();
        salesItems.add(salesItem);
        return salesItem;
    }
}
