package by.dziomin.trade.manager;

import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

/**
 * Product manager
 *
 * @author - Pavel Dziomin
 */
public interface ProductManager extends Manager {

    /**
     * Get product by search text
     *
     * @param searchText search text
     * @return product list
     * @throws ServiceException exception
     */
    List<ProductDTO> getProducts(final String searchText) throws ServiceException;

    /**
     * Get product by id
     *
     * @param productId product id
     * @return product
     * @throws ServiceException exception
     */
    ProductDTO getProductById(Long productId) throws ServiceException;

    /**
     * Update existing product
     *
     * @param productDTO product dto to update
     * @return updated product
     * @throws ServiceException    service exception
     * @throws ValidationException validation exception
     */
    ProductDTO updateProduct(ProductUpdateDTO productDTO) throws ServiceException, ValidationException;

    /**
     * Create new product
     *
     * @param productDTO product dto to create
     * @return created product
     * @throws ValidationException validation exception
     * @throws ServiceException    service exception
     */
    ProductDTO createProduct(ProductCreateDTO productDTO) throws ValidationException, ServiceException;

    /**
     * Delete product by id
     *
     * @param productId product id
     * @throws ServiceException service exception
     */
    void deleteProduct(Long productId) throws ServiceException;
}
