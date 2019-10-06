package by.dziomin.trade.manager.impl;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.validator.ValidationException;

import java.util.List;

public class ProductManagerImpl extends BaseManager implements ProductManager {

    private static ProductManager instance;

    private ProductManagerImpl() {
    }

    public static ProductManager getInstance() {
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
        return convert(product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(final ProductUpdateDTO productDTO) throws ValidationException, ServiceException {
        validate(productDTO);
        Product product = convert(productDTO, Product.class);

        ProductService service = new ProductService();
        service.updateProduct(product);
        Product updated = service.getProductById(productDTO.getId());
        return convert(updated, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(final ProductCreateDTO productDTO) throws ValidationException, ServiceException {
        validate(productDTO);
        Product product = convert(productDTO, Product.class);

        ProductService service = new ProductService();
        service.createProduct(product);
        Product created = service.getProductByBarcode(productDTO.getBarcode());
        return convert(created, ProductDTO.class);
    }

    @Override
    public void deleteProduct(final Integer productId) throws ServiceException {
        ProductService service = new ProductService();
        service.deleteProduct(productId);
    }
}
