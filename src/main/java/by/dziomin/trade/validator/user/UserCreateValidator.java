package by.dziomin.trade.validator.user;

import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.Validator;

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

        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity existing = service.getUserByLogin(user.getLogin());
        if (existing != null) {
            throw new ValidationException("USER_ALREADY_EXIST");
        }
    }
}
