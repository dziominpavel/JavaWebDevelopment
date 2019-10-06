package by.dziomin.trade.command.auth;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNIN_PAGE;

public class LoginCommand implements Command {
    private Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            UserManager userManager = ManagerFactory.getManager(UserManager.class);
            SessionUserDTO userDTO = userManager.login(login, password);
            request.getSession().setAttribute("currentUser", userDTO);
            logger.debug("Login success: " + login);
            return HOME_PAGE;
        } catch (ValidationException e) {
            request.setAttribute("wrongData", e.getMessage());
            logger.debug("Login failed: " + login, e);
            return SIGNIN_PAGE;
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
    }
}
