package by.dziomin.trade.command.admin;

import by.dziomin.trade.command.PaginationCommand;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.USERS_PAGE;

public class UsersCommand extends PaginationCommand {
    private Logger logger = Logger.getLogger(UsersCommand.class);

    @Override
    protected List<Role> getRequiredRoles() {
        return Collections.singletonList(Role.ADMIN);
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        try {
            UserManager manager =
                    ManagerFactory.getManager(UserManager.class);
            List<UserDTO> userList = manager.getUsers();
            List<UserDTO> usersOnPage = executePagination(request,
                    userList);
            request.setAttribute("users", usersOnPage);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return USERS_PAGE;
    }
}

