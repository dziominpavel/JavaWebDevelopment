package by.dziomin.trade.manager.impl;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

public class UserManagerImpl extends BaseManager implements UserManager {

    private static UserManager instance;

    private UserManagerImpl() {
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManagerImpl();
        }
        return instance;
    }

    @Override
    public SessionUserDTO login(String login, String password) throws ServiceException, ValidationException {
        UserService service = new UserService();
        User user = service.getUserByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return convert(user, SessionUserDTO.class);
        } else {
            throw new ValidationException("SIGN_IN_FAILED");
        }
    }

    public SessionUserDTO registration(UserCreateDTO userDto) throws ValidationException, ServiceException {
        validate(userDto);
        User user = convert(userDto, User.class);

        UserService userService = new UserService();
        userService.createUser(user);
        User created = userService.getUserByLogin(userDto.getLogin());
        if (created != null) {
            return convert(created, SessionUserDTO.class);
        } else {
            throw new ServiceException("USER_CREATE_FAILED");
        }
    }

    @Override
    public UserDTO getCurrentUser(final SessionUserDTO currentUser) throws ServiceException {
        UserService service = new UserService();
        User user = service.getUserByLogin(currentUser.getLogin());
        return convert(user, UserDTO.class);
    }

    @Override
    public SessionUserDTO updateUser(final UserUpdateDTO userDTO) throws ValidationException, ServiceException {
        validate(userDTO);

        UserService service = new UserService();
        User existingUser = service.getUserById(userDTO.getId());
        if (existingUser == null) {
            throw new ValidationException("USER_NOT_FOUND");
        }

        User user = convert(userDTO, existingUser, User.class);
        service.updateUser(user);
        User updated = service.getUserById(userDTO.getId());
        return convert(updated, SessionUserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() throws ServiceException {
        UserService service = new UserService();
        List<User> userList = service.getAllUsers();
        Converter<User, UserDTO> converter = getConverter(User.class,
                UserDTO.class);
        return converter.convertEntityList(userList);
    }
}
