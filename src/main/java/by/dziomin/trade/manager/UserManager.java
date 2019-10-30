package by.dziomin.trade.manager;

import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

/**
 * Manager for user
 *
 * @author - Pavel Dziomin
 */
public interface UserManager extends Manager {

    /**
     * Login with password
     *
     * @param login    login
     * @param password password
     * @return logged user
     * @throws ServiceException    service exception
     * @throws ValidationException validation exception
     */
    SessionUserDTO login(String login, String password) throws ServiceException, ValidationException;

    /**
     * Register user
     *
     * @param userDto user dto to register
     * @return registered user
     * @throws ValidationException validation exception
     * @throws ServiceException    service exception
     */
    SessionUserDTO registration(UserCreateDTO userDto) throws ValidationException, ServiceException;

    /**
     * Get current user
     *
     * @param currentUser current user to get
     * @return current user
     * @throws ServiceException service exception
     */
    UserDTO getCurrentUser(SessionUserDTO currentUser) throws ServiceException;

    /**
     * Get user role
     *
     * @param login user login
     * @return user role
     * @throws ServiceException service exception
     */
    Role getUserRole(String login) throws ServiceException;

    /**
     * UPdate user
     *
     * @param userDTO     user dto to update
     * @param currentUser current user
     * @return updated user
     * @throws ValidationException validation exception
     * @throws ServiceException    service exception
     */
    SessionUserDTO updateUser(UserUpdateDTO userDTO, final SessionUserDTO currentUser) throws ValidationException, ServiceException;

    /**
     * Get users list
     *
     * @return users list
     * @throws ServiceException service exception
     */
    List<UserDTO> getUsers() throws ServiceException;

    /**
     * Get user by user id
     *
     * @param userId user id
     * @return user
     * @throws ValidationException validation exception
     * @throws ServiceException    service exception
     */
    UserDTO getUser(Long userId) throws ValidationException, ServiceException;
}
