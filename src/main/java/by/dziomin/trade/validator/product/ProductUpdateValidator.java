package by.dziomin.trade.validator.product;

import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

import java.math.BigDecimal;

import static by.dziomin.trade.util.ErrorMessages.BARCODE_EXIST;
import static by.dziomin.trade.util.ErrorMessages.COUNT_INVALID;
import static by.dziomin.trade.util.ErrorMessages.NAME_IS_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.PRICE_INVALID;

/**
 * Validator for product update
 *
 * @author - Pavel Dziomin
 */
public final class ProductUpdateValidator implements Validator<ProductUpdateDTO> {

    private static ProductUpdateValidator instance;

    private ProductUpdateValidator() {
    }

    public static ProductUpdateValidator getInstance() {
        if (instance == null) {
            instance = new ProductUpdateValidator();
        }
        return instance;
    }

    @Override
    public void validate(final ProductUpdateDTO dto) throws ValidationException, ServiceException {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new ValidationException(NAME_IS_EMPTY);
        }

        if (dto.getCount() == null || dto.getCount() < 0) {
            throw new ValidationException(COUNT_INVALID);
        }

        if (dto.getPrice() == null || dto.getPrice().compareTo(BigDecimal.ZERO) < 1) {
            throw new ValidationException(PRICE_INVALID);
        }

        ProductService service =
                ServiceFactory.getService(ProductService.class);
        ProductEntity existing = service.getProductByBarcode(dto.getBarcode());
        if (existing != null && !existing.getId().equals(dto.getId())) {
            throw new ValidationException(BARCODE_EXIST);
        }
    }
}
