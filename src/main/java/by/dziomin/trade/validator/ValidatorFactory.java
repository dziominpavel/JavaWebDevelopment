package by.dziomin.trade.validator;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.validator.product.ProductCreateValidator;
import by.dziomin.trade.validator.product.ProductUpdateValidator;
import by.dziomin.trade.validator.receipt.ReceiptCreateValidator;
import by.dziomin.trade.validator.user.UserCreateValidator;
import by.dziomin.trade.validator.user.UserUpdateValidator;

import java.util.HashMap;
import java.util.Map;

/**
 * Validator factory
 *
 * @author - Pavel Dziomin
 */
public final class ValidatorFactory {
    private static Map<Class, Validator> validators;

    static {
        validators = new HashMap<>();

        validators.put(UserCreateDTO.class, UserCreateValidator.getInstance());
        validators.put(UserUpdateDTO.class, UserUpdateValidator.getInstance());
        validators.put(ProductUpdateDTO.class, ProductUpdateValidator.getInstance());
        validators.put(ProductCreateDTO.class, ProductCreateValidator.getInstance());
        validators.put(ReceiptCreateDTO.class, ReceiptCreateValidator.getInstance());
    }

    private ValidatorFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseDTO> Validator<T> getValidator(Class<T> classToValidate) {
        return validators.get(classToValidate);
    }
}
