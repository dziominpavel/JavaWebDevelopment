package by.dziomin.trade.command;

import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.UserManager;
import by.dziomin.trade.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ACCESS_DENIED_PAGE;

public abstract class BaseCommand implements Command {

    protected abstract String executeCheckedCommand(final HttpServletRequest request);

    @Override
    public final String execute(final HttpServletRequest request) {
        try {
            SessionUserDTO currentUser = (SessionUserDTO) request.getSession()
                    .getAttribute("currentUser");

            Role userRole = null;
            if (currentUser != null) {
                UserManager userManager =
                        ManagerFactory.getManager(UserManager.class);
                userRole = userManager.getUserRole(currentUser.getLogin());
            }

            checkPermissions(userRole);
        } catch (Exception e) {
            return ACCESS_DENIED_PAGE;
        }
        return executeCheckedCommand(request);
    }

    private void checkPermissions(Role userRole) throws ServiceException {
        if (getRequiredRoles().isEmpty()) {
            return;
        }

        if (userRole == null || !getRequiredRoles().contains(userRole)) {
            throw new ServiceException("COMMAND_ACCESS_DENIED");
        }
    }

    protected List<Role> getRequiredRoles() {
        return Collections.emptyList();
    }
}
