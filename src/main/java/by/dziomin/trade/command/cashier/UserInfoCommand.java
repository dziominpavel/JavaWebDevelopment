package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

public class UserInfoCommand implements Command {
    private Logger logger = Logger.getLogger(UserInfoCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
        SessionUserDTO currentUser = (SessionUserDTO) request.getSession().getAttribute(
                "currentUser");
        try {
            UserManager userManager =
                    ManagerFactory.getManager(UserManager.class);
            UserDTO userDTO = userManager.getCurrentUser(currentUser);
            request.setAttribute("user", userDTO);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return USER_INFO_PAGE;
    }
}
