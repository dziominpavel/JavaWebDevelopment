package by.dziomin.trade.command.manager;

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
 * Command to delete product
 *
 * @author - Pavel Dziomin
 */
public class ProductDeleteCommand extends PaginationCommand {
    private Logger logger = LogManager.getLogger();

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.ADMIN, Role.MANAGER);
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        String searchText = (String) request.getSession().getAttribute("searchText");
        try {
            String productId = request.getParameter("productId");
            ProductManager manager =
                    ManagerFactory.getManager(ProductManager.class);
            manager.deleteProduct(Long.parseLong(productId));

            List<ProductDTO> productDTOList = manager.getProducts(searchText);
            List<ProductDTO> productsOnPage = executePagination(request,
                    productDTOList);
            request.setAttribute("products", productsOnPage);
            return PRODUCTS_PAGE;
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
    }
}
