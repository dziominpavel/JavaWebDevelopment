package by.dziomin.trade.converter.product;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.entity.MeasureEntity;
import by.dziomin.trade.entity.ProductEntity;

public class ProductConverter extends BaseConverter<ProductEntity, ProductDTO> {

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
    public ProductDTO convert(final ProductEntity product) {
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
    public ProductEntity convert(final ProductDTO dto) {
        ProductEntity product = new ProductEntity();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setBarcode(dto.getBarcode());
        product.setCount(dto.getCount());
        product.setPrice(dto.getPrice());
        if (dto.getMeasure() != null && !dto.getMeasure().isEmpty()) {
            MeasureEntity measure = new MeasureEntity();
            measure.setName(dto.getMeasure());
            product.setMeasure(measure);
        }
        return product;
    }
}
