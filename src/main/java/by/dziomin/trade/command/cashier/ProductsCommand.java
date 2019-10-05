package by.dziomin.trade.command.cashier;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.command.PaginationCommand;
import by.dziomin.trade.dto.ProductDTO;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.manager.impl.ProductManagerImpl;
import by.dziomin.trade.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCTS_PAGE;

public class ProductsCommand extends PaginationCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        try {
            ProductManager manager = ProductManagerImpl.getInstance();
            List<ProductDTO> productList = manager.getProducts();
            List<ProductDTO> productsOnPage = executePagination(request, productList);
            request.setAttribute("products", productsOnPage);
        } catch (ServiceException e) {
            e.printStackTrace();
            return ERROR_PAGE;
        }

        return PRODUCTS_PAGE;
    }
}
