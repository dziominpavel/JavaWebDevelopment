package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.UserEntity;

public class UserUpdateConverter extends BaseConverter<UserEntity, UserUpdateDTO> {
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
    public UserEntity convert(final UserUpdateDTO dto, final UserEntity existingUser) {
        existingUser.setName(dto.getName());
        String password = dto.getPassword();
        if (!password.contains("/u2022")) {
            existingUser.setPassword(password);
        }
        return existingUser;
    }
}
