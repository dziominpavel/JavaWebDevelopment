package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.User;

public class UserCreateConverter extends BaseConverter<User, UserCreateDTO> {

    private static UserCreateConverter instance;

    private UserCreateConverter() {
    }

    public static UserCreateConverter getInstance() {
        if (instance == null) {
            instance = new UserCreateConverter();
        }
        return instance;
    }

    @Override
    public User convert(final UserCreateDTO dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setRole(Role.USER);
        return user;
    }
}
