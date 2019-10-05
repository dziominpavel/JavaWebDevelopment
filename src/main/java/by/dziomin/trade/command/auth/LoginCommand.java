package by.dziomin.trade.command.auth;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.UserDTO;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNIN_PAGE;

public class LoginCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            UserService service = new UserService();
            User user = service.getUserByLogin(login);
            if (user != null && user.getPassword().equals(password)) {
                request.setAttribute("message", "SIGNED_IN");

                UserDTO userDTO = new UserDTO();
                userDTO.setName(user.getName());
                userDTO.setLogin(user.getLogin());
                userDTO.setRole(user.getRole().name());
                request.getSession().setAttribute("currentUser", userDTO);
                return HOME_PAGE;
            } else {
                request.setAttribute("wrongData", "SIGN_IN_FAILED");
                return SIGNIN_PAGE;
            }
        } catch (ServiceException e) {
            e.printStackTrace(); //todo
            return ERROR_PAGE;
        }
    }
}
