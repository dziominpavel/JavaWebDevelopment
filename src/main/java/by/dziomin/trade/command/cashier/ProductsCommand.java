package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.command.PaginationCommand;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCTS_PAGE;

public class ProductsCommand extends PaginationCommand implements Command {
    private Logger logger = Logger.getLogger(ProductsCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
        try {
            ProductManager manager = ManagerFactory.getManager(ProductManager.class);
            List<ProductDTO> productList = manager.getProducts();
            List<ProductDTO> productsOnPage = executePagination(request, productList);
            request.setAttribute("products", productsOnPage);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }

        return PRODUCTS_PAGE;
    }
}