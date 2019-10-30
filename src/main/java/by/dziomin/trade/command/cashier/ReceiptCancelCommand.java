package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.entity.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.HOME_PAGE;

/**
 * Command to cancel receipt
 *
 * @author - Pavel Dziomin
 */
public class ReceiptCancelCommand extends BaseCommand {

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        request.getSession().removeAttribute("currentReceipt");
        return HOME_PAGE;
    }
}
