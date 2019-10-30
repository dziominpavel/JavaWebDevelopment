package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.PaginationCommand;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCTS_PAGE;

/**
 * Command to get products list
 *
 * @author - Pavel Dziomin
 */
public class ProductsCommand extends PaginationCommand {
    private Logger logger = LogManager.getLogger();

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.values());
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        String searchText = request.getParameter("searchText");
        try {
            ProductManager manager = ManagerFactory.getManager(ProductManager.class);
            List<ProductDTO> productList = manager.getProducts(searchText);
            List<ProductDTO> productsOnPage = executePagination(request, productList);
            request.setAttribute("products", productsOnPage);
            request.getSession().setAttribute("searchText", searchText);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return PRODUCTS_PAGE;
    }
}
