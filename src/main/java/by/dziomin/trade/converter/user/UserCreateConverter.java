package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;

/**
 * Converter for UserEntity and UserCreateDTO
 *
 * @author - Pavel Dziomin
 */
public class UserCreateConverter extends BaseConverter<UserEntity, UserCreateDTO> {

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
    public UserEntity convert(final UserCreateDTO dto) {
        UserEntity user = new UserEntity();
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setRole(Role.USER);
        return user;
    }
}
