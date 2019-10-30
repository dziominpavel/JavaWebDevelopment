package by.dziomin.trade.validator.user;

import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

import static by.dziomin.trade.util.ErrorMessages.LOGIN_IS_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.NAME_IS_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.PASSWORD_CONFIRM_NOT_EQUALS;
import static by.dziomin.trade.util.ErrorMessages.PASSWORD_IS_EMPTY;
import static by.dziomin.trade.util.ErrorMessages.USER_ALREADY_EXIST;
import static by.dziomin.trade.util.ErrorMessages.WRONG_LOGIN_FORMAT;
import static by.dziomin.trade.util.ErrorMessages.WRONG_NAME_FORMAT;
import static by.dziomin.trade.util.ErrorMessages.WRONG_PASSWORD_FORMAT;

/**
 * Validator to create user
 *
 * @author - Pavel Dziomin
 */
public class UserCreateValidator implements Validator<UserCreateDTO> {
    private static UserCreateValidator instance;

    private UserCreateValidator() {
    }

    public static UserCreateValidator getInstance() {
        if (instance == null) {
            instance = new UserCreateValidator();
        }
        return instance;
    }

    @Override
    public void validate(final UserCreateDTO user) throws ValidationException, ServiceException {
        String login = user.getLogin();
        if (login == null || login.isEmpty()) {
            throw new ValidationException(LOGIN_IS_EMPTY);
        }
        String loginPattern = "[A-Za-z0-9._]{4,32}";
        if (!login.matches(loginPattern)) {
            throw new ValidationException(WRONG_LOGIN_FORMAT);
        }

        String name = user.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException(NAME_IS_EMPTY);
        }
        String namePattern = "[^<>]{8,32}";
        if (!name.matches(namePattern)) {
            throw new ValidationException(WRONG_NAME_FORMAT);
        }

        String password = user.getPassword();
        if (password == null || password.isEmpty()) {
            throw new ValidationException(PASSWORD_IS_EMPTY);
        }
        String passwordPattern = "[^<>]{8,32}";
        if (!password.matches(passwordPattern)) {
            throw new ValidationException(WRONG_PASSWORD_FORMAT);
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new ValidationException(PASSWORD_CONFIRM_NOT_EQUALS);
        }

        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity existing = service.getUserByLogin(user.getLogin());
        if (existing != null) {
            throw new ValidationException(USER_ALREADY_EXIST);
        }
    }
}
