package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_INFO_PAGE;

public class ProductInfoCommand implements Command {
    private Logger logger = Logger.getLogger(ProductInfoCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
        try {
            Integer productId = Integer.parseInt(request.getParameter(
                    "productId"));
            ProductManager manager = ManagerFactory.getManager(ProductManager.class);
            ProductDTO product = manager.getProductById(productId);
            request.setAttribute("product", product);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
        return PRODUCT_INFO_PAGE;
    }
}
