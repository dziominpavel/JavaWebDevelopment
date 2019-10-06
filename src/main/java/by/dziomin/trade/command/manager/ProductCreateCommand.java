package by.dziomin.trade.command.manager;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_INFO_PAGE;

public class ProductCreateCommand implements Command {
    private Logger logger = Logger.getLogger(ProductCreateCommand.class);

    @Override
    public String execute(final HttpServletRequest request) {
        ProductCreateDTO productDTO = getProductDTO(request);
        try {
            ProductManager manager =
                    ManagerFactory.getManager(ProductManager.class);
            ProductDTO created = manager.createProduct(productDTO);
            request.setAttribute("product", created);
            return PRODUCT_INFO_PAGE;
        } catch (ValidationException e) {
            logger.error("Product data invalid", e);
            request.setAttribute("product", productDTO);
            request.setAttribute("wrongData", e.getMessage());
            return PRODUCT_INFO_PAGE;
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
    }

    private ProductCreateDTO getProductDTO(final HttpServletRequest request) {
        String barcode = request.getParameter("barcode");
        String name = request.getParameter("name");
        String measure = request.getParameter("measure");
        String count = request.getParameter("count");
        String price = request.getParameter("price");

        ProductCreateDTO productDTO = new ProductCreateDTO();
        productDTO.setBarcode(barcode);
        productDTO.setName(name);
        productDTO.setMeasure(measure);
        productDTO.setCount(Integer.parseInt(count));
        productDTO.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
        return productDTO;
    }
}
