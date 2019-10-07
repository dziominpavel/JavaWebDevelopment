package by.dziomin.trade.converter.user;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.entity.User;

public class SessionUserConverter extends BaseConverter<User, SessionUserDTO> {

    private static SessionUserConverter instance;

    private SessionUserConverter() {
    }

    public static SessionUserConverter getInstance() {
        if (instance == null) {
            instance = new SessionUserConverter();
        }
        return instance;
    }

    @Override
    public SessionUserDTO convert(final User entity) {
        SessionUserDTO userDTO = new SessionUserDTO();
        userDTO.setName(entity.getName());
        userDTO.setLogin(entity.getLogin());
        userDTO.setRole(entity.getRole().name());
        return userDTO;
    }

    @Override
    public User convert(final SessionUserDTO dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        return user;
    }
}
