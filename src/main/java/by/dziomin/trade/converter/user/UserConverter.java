package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.entity.User;

public class UserConverter extends BaseConverter<User, UserDTO> {
    private static UserConverter instance;

    private UserConverter() {
    }

    public static UserConverter getInstance() {
        if (instance == null) {
            instance = new UserConverter();
        }
        return instance;
    }

    @Override
    public UserDTO convert(final User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setName(entity.getName());
        userDTO.setLogin(entity.getLogin());
        userDTO.setRole(entity.getRole().name());
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < entity.getPassword().length(); i++) {
            password.append("/u2022");
        }
        userDTO.setPassword(password.toString());
        return userDTO;
    }
}
