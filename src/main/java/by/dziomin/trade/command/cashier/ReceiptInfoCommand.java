package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ReceiptManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.RECEIPT_INFO_PAGE;

/**
 * Command to ger receipt info
 *
 * @author - Pavel Dziomin
 */
public class ReceiptInfoCommand extends BaseCommand {
    private Logger logger = LogManager.getLogger();

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        try {
            Long receiptId = Long.parseLong(request.getParameter("receiptId"));
            ReceiptManager manager =
                    ManagerFactory.getManager(ReceiptManager.class);
            ReceiptDTO receipt = manager.getReceipt(receiptId);
            request.setAttribute("receipt", receipt);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return RECEIPT_INFO_PAGE;
    }
}
