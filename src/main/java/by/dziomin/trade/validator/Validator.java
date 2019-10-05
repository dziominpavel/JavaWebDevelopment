package by.dziomin.trade.validator;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.service.ServiceException;

public interface Validator<T extends BaseDTO> {
    void validate(T dto) throws ValidationException, ServiceException;
}
