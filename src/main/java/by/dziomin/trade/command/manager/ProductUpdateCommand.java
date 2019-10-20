package by.dziomin.trade.command.manager;

import by.dziomin.trade.command.BaseCommand;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.entity.Role;
import by.dziomin.trade.manager.ManagerFactory;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_INFO_PAGE;

public class ProductUpdateCommand extends BaseCommand {
    private Logger logger = Logger.getLogger(ProductUpdateCommand.class);

    @Override
    protected List<Role> getRequiredRoles() {
        return Arrays.asList(Role.ADMIN, Role.MANAGER);
    }

    @Override
    protected String executeCheckedCommand(final HttpServletRequest request) {
        ProductUpdateDTO productDTO = getProductDTO(request);
        try {
            ProductManager manager =
                    ManagerFactory.getManager(ProductManager.class);
            ProductDTO updated = manager.updateProduct(productDTO);
            request.setAttribute("product", updated);
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

    private ProductUpdateDTO getProductDTO(final HttpServletRequest request) {
        String id = request.getParameter("productId");
        String barcode = request.getParameter("barcode");
        String name = request.getParameter("name");
        String measure = request.getParameter("measure");
        String count = request.getParameter("count");
        String price = request.getParameter("price");

        ProductUpdateDTO productDTO = new ProductUpdateDTO();
        if (id != null && !id.isEmpty()) {
            productDTO.setId(Long.parseLong(id));
        }
        productDTO.setBarcode(barcode);
        productDTO.setName(name);
        productDTO.setMeasure(measure);
        productDTO.setCount(Integer.parseInt(count));
        productDTO.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
        return productDTO;
    }
}
