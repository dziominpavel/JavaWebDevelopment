package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.ProductDTO;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.manager.impl.ProductManagerImpl;
import by.dziomin.trade.service.ServiceException;

import javax.servlet.http.HttpServletRequest;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_INFO_PAGE;

public class ProductInfoCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        try {
            Integer productId = Integer.parseInt(request.getParameter(
                    "productId"));
            ProductManager manager = ProductManagerImpl.getInstance();
            ProductDTO product = manager.getProductById(productId);
            request.setAttribute("product", product);
        } catch (ServiceException e) {
            e.printStackTrace();
            return ERROR_PAGE;
        }
        return PRODUCT_INFO_PAGE;
    }
}
