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
        String name = user.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("NAME_IS_EMPTY");
        }
        String namePattern = "[^<>]{8,32}";
        if (!name.matches(namePattern)) {
            throw new ValidationException("WRONG_NAME_FORMAT");
        }

        String password = user.getPassword();
        if (password == null || password.isEmpty()) {
            throw new ValidationException("PASSWORD_IS_EMPTY");
        }
        String passwordPattern = "[^<>]{8,32}";
        if (!password.matches(passwordPattern)) {
            throw new ValidationException("WRONG_PASSWORD_FORMAT");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new ValidationException("PASSWORD_CONFIRM_NOT_EQUALS");
        }
    }
}
