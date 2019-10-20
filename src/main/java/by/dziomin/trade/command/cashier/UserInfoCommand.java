package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

public class UserInfoCommand extends BaseCommand {
    private Logger logger = Logger.getLogger(UserInfoCommand.class);

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        SessionUserDTO currentUser = (SessionUserDTO) request.getSession().getAttribute(
                "currentUser");
        try {
            UserManager userManager =
                    ManagerFactory.getManager(UserManager.class);
            UserDTO userDTO = userManager.getCurrentUser(currentUser);

            String selectedUserId = request.getParameter("userId");
            if (selectedUserId != null && !selectedUserId.isEmpty()
                    && userDTO.getRole().equals(Role.ADMIN.name())) {
                userDTO = userManager.getUser(Long.parseLong(selectedUserId));
            }

            request.setAttribute("user", userDTO);
            request.setAttribute("roleList", Role.values());
        } catch (ServiceException | ValidationException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return USER_INFO_PAGE;
    }
}
