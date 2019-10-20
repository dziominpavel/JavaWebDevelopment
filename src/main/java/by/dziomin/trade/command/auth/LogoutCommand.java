package by.dziomin.trade.command.auth;

import by.dziomin.trade.command.BaseCommand;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.SIGNIN_PAGE;

public class LogoutCommand extends BaseCommand {
    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        request.getSession().removeAttribute("currentUser");
        return SIGNIN_PAGE;
    }
}
