package by.dziomin.trade.manager;

import by.dziomin.trade.dto.ProductDTO;
import by.dziomin.trade.service.ServiceException;

import java.util.List;

public interface ProductManager {

    List<ProductDTO> getProducts() throws ServiceException;

    ProductDTO getProductById(Integer productId) throws ServiceException;
}
