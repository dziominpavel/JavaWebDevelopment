package by.dziomin.trade.manager.impl;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.dto.ProductDTO;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;

import java.util.List;

public class ProductManagerImpl extends BaseManager implements ProductManager {

    private static ProductManager instance;

    private ProductManagerImpl() {
    }

    public static ProductManager getInstance(){
        if (instance == null) {
            instance = new ProductManagerImpl();
        }
        return instance;
    }

    @Override
    public List<ProductDTO> getProducts() throws ServiceException {
        ProductService service = new ProductService();
        List<Product> productList = service.getAllProducts();
        Converter<Product, ProductDTO> converter = getConverter(Product.class, ProductDTO.class);
        return converter.convertEntityList(productList);
    }

    @Override
    public ProductDTO getProductById(final Integer productId) throws ServiceException {
        ProductService service = new ProductService();
        Product product = service.getProductById(productId);
        Converter<Product, ProductDTO> converter = getConverter(Product.class, ProductDTO.class);
        return converter.convert(product);
    }
}
