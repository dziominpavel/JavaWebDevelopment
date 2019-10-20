package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.PaginationCommand;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.dto.user.UserDTO;
import by.dziomin.trade.dto.user.UserUpdateDTO;
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
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.USERS_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

public class UserUpdateCommand extends PaginationCommand {
    private Logger logger = Logger.getLogger(UserUpdateCommand.class);

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        SessionUserDTO currentUser = (SessionUserDTO) request.getSession().getAttribute(
                "currentUser");

        UserUpdateDTO userDTO = getUserUpdateDTO(request);
        try {
            UserManager userManager =
                    ManagerFactory.getManager(UserManager.class);
            SessionUserDTO updated = userManager.updateUser(userDTO, currentUser);

            //if updated current user
            if (currentUser.getLogin().equals(updated.getLogin())) {
                request.getSession().setAttribute("currentUser", updated);
            }
            logger.debug("User update success: " + updated.getLogin());

            if (currentUser.getRole().equals(Role.ADMIN.name())) {
                List<UserDTO> userList = userManager.getUsers();
                List<UserDTO> usersOnPage = executePagination(request,
                        userList);
                request.setAttribute("users", usersOnPage);
                return USERS_PAGE;
            } else {
                return HOME_PAGE;
            }
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");
        String role = request.getParameter("role");

        UserUpdateDTO userDto = new UserUpdateDTO();
        userDto.setId(Long.parseLong(id));
        userDto.setName(name);
        userDto.setPassword(password);
        userDto.setConfirmPassword(confirmPassword);
        if (role != null) {
            userDto.setRole(Role.valueOf(role));
        }
        return userDto;
    }
}
