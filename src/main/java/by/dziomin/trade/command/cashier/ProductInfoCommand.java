package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_INFO_PAGE;

public class ProductInfoCommand extends BaseCommand {
    private Logger logger = Logger.getLogger(ProductInfoCommand.class);

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        try {
            Long productId = Long.parseLong(request.getParameter(
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
