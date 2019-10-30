package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.PaginationCommand;
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
import static by.dziomin.trade.command.AppUrls.RECEIPT_PAGE;

/**
 * Command to get receipts list
 *
 * @author - Pavel Dziomin
 */
public class ReceiptsCommand extends PaginationCommand {
    private Logger logger = LogManager.getLogger();

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        try {
            ReceiptManager manager =
                    ManagerFactory.getManager(ReceiptManager.class);
            List<ReceiptDTO> receiptList = manager.getReceipts();
            List<ReceiptDTO> receiptsOnPage = executePagination(request,
                    receiptList);
            request.setAttribute("receipts", receiptsOnPage);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return RECEIPT_PAGE;
    }
}
