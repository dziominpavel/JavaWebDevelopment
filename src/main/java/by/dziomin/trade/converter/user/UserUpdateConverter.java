package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.User;

public class UserUpdateConverter extends BaseConverter<User, UserUpdateDTO> {
    private static UserUpdateConverter instance;

    private UserUpdateConverter() {
    }

    public static UserUpdateConverter getInstance() {
        if (instance == null) {
            instance = new UserUpdateConverter();
        }
        return instance;
    }

    @Override
    public User convert(final UserUpdateDTO dto, final User existingUser) {
        existingUser.setName(dto.getName());
        String password = dto.getPassword();
        if (!password.contains("/u2022")) {
            existingUser.setPassword(password);
        }
        return existingUser;
    }
}
