package by.dziomin.trade.validator;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.service.ServiceException;

/**
 * Validator
 *
 * @param <T> subclass BaseDTO to validate
 */
public interface Validator<T extends BaseDTO> {
    /**
     * validate dto.
     *
     * @param dto dto entity
     * @throws ValidationException ValidationException
     * @throws ServiceException    ServiceException
     */
    void validate(T dto) throws ValidationException, ServiceException;
}
