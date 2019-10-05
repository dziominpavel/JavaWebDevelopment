package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.UserDTO;
import by.dziomin.trade.dto.UserUpdateDTO;
import by.dziomin.trade.entity.User;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.UserService;
import by.dziomin.trade.validator.ValidationException;
import by.dziomin.trade.validator.user.UserUpdateValidator;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

public class UserUpdateCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        UserDTO currentUser = (UserDTO) request.getSession().getAttribute(
                "currentUser");

        UserUpdateDTO userDto = getUserUpdateDTO(request);
        try {
            UserUpdateValidator validator = new UserUpdateValidator();
            validator.validate(userDto);

            UserService service = new UserService();
            User userEntity = service.getUserByLogin(currentUser.getLogin());
            userEntity.setName(userDto.getName());
            userEntity.setPassword(userDto.getPassword());

            service.updateUser(userEntity);
            User updated = service.getUserByLogin(currentUser.getLogin());
            currentUser.setName(updated.getName());

            return HOME_PAGE;
        } catch (ValidationException e) {
            request.setAttribute("wrongData", e.getMessage());
            return USER_INFO_PAGE;
        } catch (ServiceException e) {
            e.printStackTrace();
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
