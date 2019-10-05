package by.dziomin.trade.validator.user;

import by.dziomin.trade.dto.UserCreateDTO;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

public class UserCreateValidator implements Validator<UserCreateDTO> {
    @Override
    public void validate(final UserCreateDTO user) throws ValidationException, ServiceException {
        //todo validation
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new ValidationException("LOGIN_IS_EMPTY");
        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ValidationException("NAME_IS_EMPTY");
        }
        //validate login size
        //validate password is empty
        //validate password size

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new ValidationException("PASSWORD_CONFIRM_NOT_EQUALS");
        }

        UserService userService = new UserService();
        User existing = userService.getUserByLogin(user.getLogin());
        if (existing != null) {
            throw new ValidationException("USER_ALREADY_EXIST");
        }
    }
}
