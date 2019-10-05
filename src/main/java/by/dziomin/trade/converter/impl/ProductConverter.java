package by.dziomin.trade.converter.impl;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.ProductDTO;
import by.dziomin.trade.entity.Measure;
import by.dziomin.trade.entity.Product;

public class ProductConverter extends BaseConverter<Product, ProductDTO> {

    private static ProductConverter instance;

    private ProductConverter() {
    }

    public static ProductConverter getInstance() {
        if (instance == null) {
            instance = new ProductConverter();
        }
        return instance;
    }

    @Override
    public ProductDTO convert(final Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBarcode(product.getBarcode());
        productDTO.setName(product.getName());
        productDTO.setCount(product.getCount());
        productDTO.setPrice(product.getPrice());
        if (product.getMeasure() != null) {
            productDTO.setMeasure(product.getMeasure().getName());
        }
        return productDTO;
    }

    @Override
    public Product convert(final ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setBarcode(dto.getBarcode());
        product.setCount(dto.getCount());
        product.setPrice(dto.getPrice());
        if (dto.getMeasure() != null && !dto.getMeasure().isEmpty()) {
            Measure measure = new Measure();
            measure.setName(dto.getMeasure());
            product.setMeasure(measure);
        }
        return product;
    }
}
