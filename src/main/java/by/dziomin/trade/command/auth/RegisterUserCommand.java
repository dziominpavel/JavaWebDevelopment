package by.dziomin.trade.command.auth;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.UserCreateDTO;
import by.dziomin.trade.dto.UserDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.user.UserCreateValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.MESSAGE_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNUP_PAGE;

public class RegisterUserCommand implements Command {
    Logger logger = Logger.getLogger(RegisterUserCommand.class);
    @Override
    public String execute(final HttpServletRequest request) {
        logger.debug("executing register command");

        UserCreateDTO userDto = getUserCreateDTO(request);

        try {
            UserCreateValidator validator = new UserCreateValidator();
            validator.validate(userDto);

            User userEntity = new User();
            userEntity.setName(userDto.getName());
            userEntity.setLogin(userDto.getLogin());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setRole(Role.USER);

            UserService userService = new UserService();
            userService.createUser(userEntity);
            User created = userService.getUserByLogin(userDto.getLogin());
            if (created != null) {

                UserDTO userDTO = new UserDTO();
                userDTO.setName(created.getName());
                userDTO.setLogin(created.getLogin());
                request.getSession().setAttribute("currentUser", userDTO);
                return HOME_PAGE;
            } else {
                request.setAttribute("message", "USER_CREATE_FAILED");
                logger.debug("register failed");
                return MESSAGE_PAGE;
            }
        } catch (ValidationException e) {
            request.setAttribute("wrongData", e.getMessage());
            return SIGNUP_PAGE;
        } catch (ServiceException e) {
            e.printStackTrace(); //todo log
            return ERROR_PAGE;
        }
    }

    private UserCreateDTO getUserCreateDTO(final HttpServletRequest request) {
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");

        UserCreateDTO userDto = new UserCreateDTO();
        userDto.setLogin(login);
        userDto.setName(name);
        userDto.setPassword(password);
        userDto.setConfirmPassword(confirmPassword);
        return userDto;
    }
}
