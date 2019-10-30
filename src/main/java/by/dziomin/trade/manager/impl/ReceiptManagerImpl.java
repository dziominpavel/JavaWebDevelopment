package by.dziomin.trade.manager.impl;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.ReceiptManager;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ReceiptService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.service.impl.ProductServiceImpl;
import by.dziomin.trade.validator.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static by.dziomin.trade.util.ErrorMessages.OUT_OF_STOCK;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_NOT_FOUND;
import static by.dziomin.trade.util.ErrorMessages.SALES_ITEM_NOT_FOUND;

/**
 * Manager for receipt
 *
 * @author - Pavel Dziomin
 */
public class ReceiptManagerImpl extends BaseManager implements ReceiptManager {

    private static ReceiptManager instance;
    private Logger logger = LogManager.getLogger();

    private ReceiptManagerImpl() {
    }

    public static ReceiptManager getInstance() {
        if (instance == null) {
            instance = new ReceiptManagerImpl();
        }
        return instance;
    }

    @Override
    public void addSalesItem(final String barcode, final Integer countToAdd, final ReceiptDTO currentReceipt) throws ServiceException, ValidationException {
        ProductService service = ProductServiceImpl.getInstance();
        ProductEntity product = service.getProductByBarcode(barcode);
        if (product == null) {
            throw new ValidationException(PRODUCT_NOT_FOUND);
        }
        ProductDTO productDTO = convert(product, ProductDTO.class);
        addSalesItemToReceipt(currentReceipt, productDTO, countToAdd);
    }

    @Override
    public void deleteSalesItem(final Long productId,
                                final ReceiptDTO currentReceipt) throws ValidationException, ServiceException {
        ProductService service = ProductServiceImpl.getInstance();
        ProductEntity product = service.getProductById(productId);
        if (product == null) {
            throw new ValidationException(PRODUCT_NOT_FOUND);
        }
        SalesItemDTO salesItem = findSalesItemInReceipt(currentReceipt.getSalesItems(),
                product.getBarcode(), false);
        if (salesItem == null) {
            throw new ServiceException(SALES_ITEM_NOT_FOUND);
        }
        currentReceipt.getSalesItems().remove(salesItem);
        calculateReceipt(currentReceipt);
    }

    @Override
    public void createReceipt(final ReceiptCreateDTO currentReceipt) throws ValidationException, ServiceException {
        validate(currentReceipt);
        ReceiptEntity receipt = convert(currentReceipt, ReceiptEntity.class);
        ReceiptService receiptService =
                ServiceFactory.getService(ReceiptService.class);
        receiptService.createReceipt(receipt);
    }

    private void addSalesItemToReceipt(ReceiptDTO currentReceipt,
                                       ProductDTO product, final Integer countToAdd) throws ValidationException {
        List<SalesItemDTO> salesItems = currentReceipt.getSalesItems();
        if (salesItems == null) {
            salesItems = new ArrayList<>();
            currentReceipt.setSalesItems(salesItems);
        }

        SalesItemDTO salesItem = findSalesItemInReceipt(salesItems,
                product.getBarcode(), true);
        salesItem.setProduct(product);

        calculateSalesItem(salesItem, countToAdd);
        calculateReceipt(currentReceipt);
    }

    private void calculateReceipt(final ReceiptDTO currentReceipt) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (SalesItemDTO salesItem : currentReceipt.getSalesItems()) {
            totalPrice = totalPrice.add(salesItem.getTotalPrice());
        }
        currentReceipt.setTotalPrice(totalPrice);
    }

    private void calculateSalesItem(final SalesItemDTO salesItem, final Integer countToAdd) throws ValidationException {
        Integer count = salesItem.getCount();
        if (count == null) {
            count = countToAdd;
        } else {
            count = count + countToAdd;
        }
        if (count > salesItem.getProduct().getCount()) {
            throw new ValidationException(OUT_OF_STOCK);
        }
        salesItem.setCount(count);

        BigDecimal price = salesItem.getProduct().getPrice();
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(count));
        salesItem.setTotalPrice(totalPrice);
    }

    private SalesItemDTO findSalesItemInReceipt(final List<SalesItemDTO> salesItems, final String barcode, boolean createIfNotFount) {
        for (SalesItemDTO item : salesItems) {
            if (barcode.equals(item.getProduct().getBarcode())) {
                return item;
            }
        }
        //create new if not found
        if (createIfNotFount) {
            SalesItemDTO salesItem = new SalesItemDTO();
            salesItems.add(salesItem);
            return salesItem;
        } else {
            return null;
        }
    }

    @Override
    public List<ReceiptDTO> getReceipts() throws ServiceException {
        ReceiptService receiptService =
                ServiceFactory.getService(ReceiptService.class);
        List<ReceiptEntity> receiptList = receiptService.getAllReceipts();

        UserService userService = ServiceFactory.getService(UserService.class);
        for (ReceiptEntity receiptEntity : receiptList) {
            UserEntity userEntity =
                    userService.getUserById(receiptEntity.getUser().getId());
            receiptEntity.setUser(userEntity);
        }

        Converter<ReceiptEntity, ReceiptDTO> converter = getConverter(ReceiptEntity.class,
                ReceiptDTO.class);
        List<ReceiptDTO> temp = converter.convertEntityList(receiptList);
        return temp;
    }

    @Override
    public ReceiptDTO getReceipt(final Long receiptId) throws ServiceException {
        ReceiptService receiptService =
                ServiceFactory.getService(ReceiptService.class);
        ReceiptEntity receiptEntity = receiptService.getReceiptById(receiptId);
        return convert(receiptEntity, ReceiptDTO.class);
    }
}
