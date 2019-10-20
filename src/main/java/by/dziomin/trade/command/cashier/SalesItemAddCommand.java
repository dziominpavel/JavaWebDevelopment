package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ReceiptManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;

public class SalesItemAddCommand extends BaseCommand {
    private Logger logger = Logger.getLogger(SalesItemAddCommand.class);

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        String barcode = request.getParameter("barcode");
        ReceiptDTO currentReceipt = getCurrentReceipt(request);
        try {
            ReceiptManager receiptManager =
                    ManagerFactory.getManager(ReceiptManager.class);
            receiptManager.addSalesItem(barcode, currentReceipt);
            request.getSession().setAttribute("currentReceipt", currentReceipt);
            request.setAttribute("barcode", barcode);
        } catch (ValidationException e) {
            request.setAttribute("wrongData", e.getMessage());
            request.setAttribute("barcode", barcode);
            logger.debug("Add sales item failed: " + barcode, e);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
        return HOME_PAGE;
    }

    private ReceiptDTO getCurrentReceipt(final HttpServletRequest request) {
        Object receiptObject = request.getSession().getAttribute(
                "currentReceipt");
        if (receiptObject != null) {
            return (ReceiptDTO) receiptObject;
        } else {
            return new ReceiptCreateDTO();
        }
    }
}
