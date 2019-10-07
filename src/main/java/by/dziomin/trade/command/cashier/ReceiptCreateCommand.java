package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ReceiptManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;

public class ReceiptCreateCommand implements Command {
    private Logger logger = Logger.getLogger(ReceiptCreateCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
        ReceiptCreateDTO currentReceipt = getCurrentReceipt(request);
        try {
            ReceiptManager receiptManager =
                    ManagerFactory.getManager(ReceiptManager.class);
            receiptManager.createReceipt(currentReceipt);
            request.getSession().removeAttribute("currentReceipt");
        } catch (ValidationException e) {
            request.setAttribute("wrongData", e.getMessage());
            logger.debug("Receipt create failed: ", e);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
        return HOME_PAGE;
    }

    private ReceiptCreateDTO getCurrentReceipt(final HttpServletRequest request) {
        Object receiptObject = request.getSession().getAttribute(
                "currentReceipt");
        ReceiptCreateDTO receiptDTO;
        if (receiptObject != null) {
            receiptDTO = (ReceiptCreateDTO) receiptObject;
            SessionUserDTO currentUser =
                    (SessionUserDTO) request.getSession().getAttribute("currentUser");
            receiptDTO.setCurrentUser(currentUser);
        } else {
            receiptDTO = new ReceiptCreateDTO();
        }
        return receiptDTO;
    }
}
