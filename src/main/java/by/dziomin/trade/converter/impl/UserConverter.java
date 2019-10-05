package by.dziomin.trade.converter.impl;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.UserDTO;
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


}
