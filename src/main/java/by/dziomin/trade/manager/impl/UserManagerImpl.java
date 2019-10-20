package by.dziomin.trade.manager.impl;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.UserEntity;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
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
        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity user = service.getUserByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return convert(user, SessionUserDTO.class);
        } else {
            throw new ValidationException("SIGN_IN_FAILED");
        }
    }

    @Override
    public SessionUserDTO registration(UserCreateDTO userDto) throws ValidationException, ServiceException {
        validate(userDto);
        UserEntity user = convert(userDto, UserEntity.class);

        UserService service = ServiceFactory.getService(UserService.class);
        service.createUser(user);
        UserEntity created = service.getUserByLogin(userDto.getLogin());
        if (created != null) {
            return convert(created, SessionUserDTO.class);
        } else {
            throw new ServiceException("USER_CREATE_FAILED");
        }
    }

    @Override
    public UserDTO getCurrentUser(final SessionUserDTO currentUser) throws ServiceException {
        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity user = service.getUserByLogin(currentUser.getLogin());
        return convert(user, UserDTO.class);
    }

    @Override
    public Role getUserRole(final String login) throws ServiceException {
        UserService service = ServiceFactory.getService(UserService.class);
        Role userRole = service.getUserRole(login);
        if (userRole == null) {
            throw new ServiceException("USER_ROLE_UNDEFINED");
        }
        return userRole;
    }

    @Override
    public SessionUserDTO updateUser(final UserUpdateDTO userDTO, final SessionUserDTO currentUser) throws ValidationException, ServiceException {
        validate(userDTO);

        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity existingUser = service.getUserById(userDTO.getId());
        if (existingUser == null) {
            throw new ServiceException("USER_NOT_FOUND");
        }

        UserEntity currentUserEntity =
                service.getUserByLogin(currentUser.getLogin());
        if (currentUserEntity == null) {
            throw new ServiceException("USER_NOT_FOUND");
        }

        //only admin can update other users
        if (currentUserEntity.getRole() != Role.ADMIN
                && !currentUserEntity.getId().equals(existingUser.getId())) {
            throw new ServiceException("NO_PERMISSIONS_TO_UPDATE_USER");
        }

        //role can be updated only by admin
        if (currentUserEntity.getRole() != Role.ADMIN) {
            userDTO.setRole(null);
        }

        UserEntity user = convert(userDTO, existingUser, UserEntity.class);
        service.updateUser(user);
        UserEntity updated = service.getUserById(userDTO.getId());
        return convert(updated, SessionUserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() throws ServiceException {
        UserService service = ServiceFactory.getService(UserService.class);
        List<UserEntity> userList = service.getAllUsers();
        Converter<UserEntity, UserDTO> converter = getConverter(UserEntity.class,
                UserDTO.class);
        return converter.convertEntityList(userList);
    }

    @Override
    public UserDTO getUser(final Long userId) throws ValidationException, ServiceException {
        UserService service = ServiceFactory.getService(UserService.class);
        UserEntity userEntity = service.getUserById(userId);
        if (userEntity == null) {
            throw new ValidationException("USER_NOT_FOUND");
        }
        return convert(userEntity, UserDTO.class);
    }
}
