package by.dziomin.trade.command.auth;

import by.dziomin.trade.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.SIGNIN_PAGE;

public class LogoutCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        request.getSession().removeAttribute("currentUser");
        return SIGNIN_PAGE;
    }
}
