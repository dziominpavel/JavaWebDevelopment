package by.dziomin.trade.manager.impl;

import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.dto.product.ProductCreateDTO;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.product.ProductUpdateDTO;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.manager.BaseManager;
import by.dziomin.trade.manager.ProductManager;
import by.dziomin.trade.service.ProductService;
import by.dziomin.trade.service.ServiceException;
import by.dziomin.trade.service.ServiceFactory;
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
        ProductService service =
                ServiceFactory.getService(ProductService.class);
        List<ProductEntity> productList = service.getAllProducts();
        Converter<ProductEntity, ProductDTO> converter = getConverter(ProductEntity.class, ProductDTO.class);
        return converter.convertEntityList(productList);
    }

    @Override
    public ProductDTO getProductById(final Long productId) throws ServiceException {
        ProductService service =
                ServiceFactory.getService(ProductService.class);
        ProductEntity product = service.getProductById(productId);
        return convert(product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(final ProductUpdateDTO productDTO) throws ValidationException, ServiceException {
        validate(productDTO);
        ProductEntity product = convert(productDTO, ProductEntity.class);

        ProductService service =
                ServiceFactory.getService(ProductService.class);

        service.updateProduct(product);
        ProductEntity updated = service.getProductById(productDTO.getId());
        return convert(updated, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(final ProductCreateDTO productDTO) throws ValidationException, ServiceException {
        validate(productDTO);
        ProductEntity product = convert(productDTO, ProductEntity.class);

        ProductService service =
                ServiceFactory.getService(ProductService.class);
        service.createProduct(product);
        ProductEntity created = service.getProductByBarcode(productDTO.getBarcode());
        return convert(created, ProductDTO.class);
    }

    @Override
    public void deleteProduct(final Long productId) throws ServiceException {
        ProductService service =
                ServiceFactory.getService(ProductService.class);
        service.deleteProduct(productId);
    }
}
