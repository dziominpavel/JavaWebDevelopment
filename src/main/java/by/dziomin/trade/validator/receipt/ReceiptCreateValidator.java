package by.dziomin.trade.validator.receipt;

import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

import java.math.BigDecimal;
import java.util.List;

import static by.dziomin.trade.util.ErrorMessages.OUT_OF_STOCK;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_NOT_FOUND;
import static by.dziomin.trade.util.ErrorMessages.PRODUCT_PRICE_INVALID;
import static by.dziomin.trade.util.ErrorMessages.RECEIPT_PRICE_INVALID;
import static by.dziomin.trade.util.ErrorMessages.SALES_ITEMS_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.SALES_ITEM_PRICE_INVALID;
import static by.dziomin.trade.util.ErrorMessages.USER_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.USER_NOT_FOUND;

/**
 * Validator to create receipt
 *
 * @author - Pavel Dziomin
 */
public final class ReceiptCreateValidator implements Validator<ReceiptCreateDTO> {
    private static ReceiptCreateValidator instance;

    private ReceiptCreateValidator() {
    }

    public static ReceiptCreateValidator getInstance() {
        if (instance == null) {
            instance = new ReceiptCreateValidator();
        }
        return instance;
    }

    @Override
    public void validate(final ReceiptCreateDTO dto) throws ValidationException, ServiceException {
        List<SalesItemDTO> salesItems = dto.getSalesItems();
        if (salesItems == null || salesItems.isEmpty()) {
            throw new ValidationException(SALES_ITEMS_EMPTY);
        }

        ProductService productService =
                ServiceFactory.getService(ProductService.class);
        BigDecimal total = BigDecimal.ZERO;
        for (SalesItemDTO salesItem : salesItems) {
            if (salesItem.getProduct() == null) {
                throw new ValidationException(PRODUCT_EMPTY);
            }

            ProductEntity existing =
                    productService.getProductById(salesItem.getProduct().getId());
            if (existing == null) {
                throw new ValidationException(PRODUCT_NOT_FOUND);
            }

            if (existing.getCount() < salesItem.getCount()) {
                throw new ValidationException(OUT_OF_STOCK);
            }

            if (existing.getPrice().compareTo(salesItem.getProduct().getPrice()) != 0) {
                throw new ValidationException(PRODUCT_PRICE_INVALID);
            }
            BigDecimal totalPrice =
                    existing.getPrice().multiply(BigDecimal.valueOf(salesItem.getCount()));
            if (totalPrice.compareTo(salesItem.getTotalPrice()) != 0) {
                throw new ValidationException(SALES_ITEM_PRICE_INVALID);
            }
            total = total.add(totalPrice);
        }

        if (total.compareTo(dto.getTotalPrice()) != 0) {
            throw new ValidationException(RECEIPT_PRICE_INVALID);
        }

        if (dto.getCurrentUser() == null) {
            throw new ValidationException(USER_EMPTY);
        }

        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity existing =
                service.getUserByLogin(dto.getCurrentUser().getLogin());
        if (existing == null) {
            throw new ValidationException(USER_NOT_FOUND);
        }
    }
}
