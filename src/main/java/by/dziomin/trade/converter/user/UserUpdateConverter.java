package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.UserEntity;

/**
 * Converter for UserEntity and UserUpdateDTO
 *
 * @author - Pavel Dziomin
 */
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
        if (password.indexOf('\u2022') == -1) {
            existingUser.setPassword(password);
        }
        if (dto.getRole() != null) {
            existingUser.setRole(dto.getRole());
        }
        return existingUser;
    }
}
