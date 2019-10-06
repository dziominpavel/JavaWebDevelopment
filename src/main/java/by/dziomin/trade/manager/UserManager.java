package by.dziomin.trade.manager;

import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

public interface UserManager extends Manager {

    SessionUserDTO login(String login, String password) throws ServiceException, ValidationException;

    SessionUserDTO registration(UserCreateDTO userDto) throws ValidationException, ServiceException;

    UserDTO getCurrentUser(SessionUserDTO currentUser) throws ServiceException;

    SessionUserDTO updateUser(UserUpdateDTO userDTO) throws ValidationException, ServiceException;
}
