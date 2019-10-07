package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.HOME_PAGE;

public class ReceiptCancelCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        request.getSession().removeAttribute("currentReceipt");
        return HOME_PAGE;
    }
}
