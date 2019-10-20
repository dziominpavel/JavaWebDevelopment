package by.dziomin.trade.command.auth;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserCreateDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNUP_PAGE;

public class RegisterUserCommand extends BaseCommand {
    private Logger logger = Logger.getLogger(RegisterUserCommand.class);

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        UserCreateDTO userDto = getUserCreateDTO(request);
        try {
            UserManager userManager =
                    ManagerFactory.getManager(UserManager.class);
            SessionUserDTO userDTO = userManager.registration(userDto);
            request.getSession().setAttribute("currentUser", userDTO);
            return HOME_PAGE;
        } catch (ValidationException e) {
            logger.error("Registration failed: " + userDto.getLogin(), e);
            request.setAttribute("wrongData", e.getMessage());
            return SIGNUP_PAGE;
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
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
