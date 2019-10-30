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
import static by.dziomin.trade.util.ErrorMessages.COMMAND_ACCESS_DENIED;

/**
 * Base class for commands
 *
 * @author - Pavel Dziomin
 */
public abstract class BaseCommand implements Command {

    /**
     * Execute command after required roles was checked
     *
     * @param request request
     * @return redirect page
     */
    protected abstract String executeCheckedCommand(HttpServletRequest request);

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

    /**
     * Get required roles for command
     *
     * @return list of roles
     */
    protected List<Role> getRequiredRoles() {
        return Collections.emptyList();
    }

    private void checkPermissions(final Role userRole) throws ServiceException {
        if (getRequiredRoles().isEmpty()) {
            return;
        }

        if (userRole == null || !getRequiredRoles().contains(userRole)) {
            throw new ServiceException(COMMAND_ACCESS_DENIED);
        }
    }
}
