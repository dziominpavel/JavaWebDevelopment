package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.command.PaginationCommand;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ReceiptManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.RECEIPT_PAGE;

public class ReceiptsCommand extends PaginationCommand implements Command {
    private Logger logger = Logger.getLogger(ReceiptsCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
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
