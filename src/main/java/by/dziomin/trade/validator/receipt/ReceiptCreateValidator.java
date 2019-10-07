package by.dziomin.trade.validator.receipt;

import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptCreateValidator implements Validator<ReceiptCreateDTO> {
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
            throw new ValidationException("SALES_ITEMS_EMPTY");
        }

        ProductService productService = new ProductService();
        BigDecimal total = BigDecimal.ZERO;
        for (SalesItemDTO salesItem : salesItems) {
            if (salesItem.getProduct() == null) {
                throw new ValidationException("PRODUCT_EMPTY");
            }

            Product existing =
                    productService.getProductById(salesItem.getProduct().getId());
            if (existing == null) {
                throw new ValidationException("PRODUCT_NOT_FOUND");
            }

            if (existing.getCount() < salesItem.getCount()) {
                throw new ValidationException("OUT_OF_STOCK");
            }

            if (existing.getPrice().compareTo(salesItem.getProduct().getPrice()) != 0) {
                throw new ValidationException("PRODUCT_PRICE_INVALID");
            }
            BigDecimal totalPrice =
                    existing.getPrice().multiply(BigDecimal.valueOf(salesItem.getCount()));
            if (totalPrice.compareTo(salesItem.getTotalPrice()) != 0) {
                throw new ValidationException("SALES_ITEM_PRICE_INVALID");
            }
            total = total.add(totalPrice);
        }

        if (total.compareTo(dto.getTotalPrice()) != 0) {
            throw new ValidationException("RECEIPT_PRICE_INVALID");
        }

        if (dto.getCurrentUser() == null) {
            throw new ValidationException("USER_EMPTY");
        }

        UserService userService = new UserService();
        User existing =
                userService.getUserByLogin(dto.getCurrentUser().getLogin());
        if (existing == null) {
            throw new ValidationException("USER_NOT_FOUND");
        }
    }
}
