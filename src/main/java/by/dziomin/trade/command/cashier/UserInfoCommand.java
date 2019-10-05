package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.UserDTO;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

public class UserInfoCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
        try {
            UserService service = new UserService();
            User user = service.getUserByLogin(currentUser.getLogin());

            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setLogin(user.getLogin());
            request.setAttribute("user", userDTO);
        } catch (ServiceException e) {
            e.printStackTrace();
            return ERROR_PAGE;
        }

        return USER_INFO_PAGE;
    }
}
