package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

public class UserUpdateCommand implements Command {
    private Logger logger = Logger.getLogger(UserUpdateCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {

        UserUpdateDTO userDTO = getUserUpdateDTO(request);
        try {
            UserManager userManager =
                    ManagerFactory.getManager(UserManager.class);
            SessionUserDTO updated = userManager.updateUser(userDTO);
            request.getSession().setAttribute("currentUser", updated);
            logger.debug("User update success: " + updated.getLogin());
            return HOME_PAGE;
        } catch (ValidationException e) {
            logger.debug("User update failed: " + userDTO.getId(), e);
            request.setAttribute("wrongData", e.getMessage());
            return USER_INFO_PAGE;
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
    }

    private UserUpdateDTO getUserUpdateDTO(final HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");

        UserUpdateDTO userDto = new UserUpdateDTO();
        userDto.setName(name);
        userDto.setPassword(password);
        userDto.setConfirmPassword(confirmPassword);
        return userDto;
    }
}
