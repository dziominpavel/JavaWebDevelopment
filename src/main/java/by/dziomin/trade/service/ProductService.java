package by.dziomin.trade.service;

import by.dziomin.trade.entity.ProductEntity;

import java.util.List;

/**
 * Service for products
 *
 * @author - Pavel Dziomin
 */
public interface ProductService extends Service {

    /**
     * Get all products.
     *
     * @return list of products
     * @throws ServiceException service exception
     */
    List<ProductEntity> getAllProducts() throws ServiceException;

    /**
     * Get product by id
     *
     * @param id product id
     * @return product
     * @throws ServiceException service exception
     */
    ProductEntity getProductById(Long id) throws ServiceException;

    /**
     * Get product by Barcode
     *
     * @param barcode barcode
     * @return product
     * @throws ServiceException service exception
     */
    ProductEntity getProductByBarcode(String barcode) throws ServiceException;

    /**
     * Update existing product
     *
     * @param product product to update
     * @throws ServiceException service exception
     */
    void updateProduct(ProductEntity product) throws ServiceException;

    /**
     * Create new product
     *
     * @param product product to create
     * @throws ServiceException service exception
     */
    void createProduct(ProductEntity product) throws ServiceException;

    /**
     * Delete product by product id
     *
     * @param productId product id
     * @throws ServiceException service exception
     */
    void deleteProduct(Long productId) throws ServiceException;

}
