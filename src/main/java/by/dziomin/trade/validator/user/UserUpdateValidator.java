package by.dziomin.trade.validator.user;

import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

public class UserUpdateValidator implements Validator<UserUpdateDTO> {
    private static UserUpdateValidator instance;

    private UserUpdateValidator() {
    }

    public static UserUpdateValidator getInstance() {
        if (instance == null) {
            instance = new UserUpdateValidator();
        }
        return instance;
    }

    @Override
    public void validate(final UserUpdateDTO user) throws ValidationException, ServiceException {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ValidationException("NAME_IS_EMPTY");
        }
        //validate login size
        //validate password is empty
        //validate password size

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new ValidationException("PASSWORD_CONFIRM_NOT_EQUALS");
        }
    }
}
