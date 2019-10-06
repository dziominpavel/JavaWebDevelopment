package by.dziomin.trade.manager;

import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

public interface ProductManager extends Manager {

    List<ProductDTO> getProducts() throws ServiceException;

    ProductDTO getProductById(Integer productId) throws ServiceException;

    ProductDTO updateProduct(final ProductUpdateDTO productDTO) throws ServiceException, ValidationException;

    ProductDTO createProduct(ProductCreateDTO productDTO) throws ValidationException, ServiceException;

    void deleteProduct(final Integer productId) throws ServiceException;
}
