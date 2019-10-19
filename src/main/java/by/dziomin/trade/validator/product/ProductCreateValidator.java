package by.dziomin.trade.validator.product;

import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

import java.math.BigDecimal;

public class ProductCreateValidator implements Validator<ProductCreateDTO> {

    private static ProductCreateValidator instance;

    private ProductCreateValidator() {
    }

    public static ProductCreateValidator getInstance() {
        if (instance == null) {
            instance = new ProductCreateValidator();
        }
        return instance;
    }

    @Override
    public void validate(final ProductCreateDTO dto) throws ValidationException, ServiceException {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new ValidationException("NAME_IS_EMPTY");
        }

        if (dto.getCount() == null || dto.getCount() < 0) {
            throw new ValidationException("COUNT_INVALID");
        }

        if (dto.getPrice() == null || dto.getPrice().compareTo(BigDecimal.ZERO) < 1) {
            throw new ValidationException("PRICE_INVALID");
        }

        ProductService service =
                ServiceFactory.getService(ProductService.class);
        ProductEntity existing = service.getProductByBarcode(dto.getBarcode());
        if (existing != null) {
            throw new ValidationException("BARCODE_EXIST");
        }
    }
}
