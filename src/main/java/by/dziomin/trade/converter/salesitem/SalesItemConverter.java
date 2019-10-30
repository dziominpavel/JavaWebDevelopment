package by.dziomin.trade.converter.salesitem;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.ProductEntity;
import by.dziomin.trade.entity.SalesItem;

/**
 * Converter for SalesItem and SalesItemDTO
 *
 * @author - Pavel Dziomin
 */
public class SalesItemConverter extends BaseConverter<SalesItem, SalesItemDTO> {
    private static SalesItemConverter instance;

    private SalesItemConverter() {
    }

    public static SalesItemConverter getInstance() {
        if (instance == null) {
            instance = new SalesItemConverter();
        }
        return instance;
    }

    @Override
    public SalesItem convert(final SalesItemDTO dto) {
        SalesItem salesItem = new SalesItem();
        salesItem.setPrice(dto.getTotalPrice());
        salesItem.setCount(dto.getCount());

        Converter<ProductEntity, ProductDTO> productConverter =
                ConverterFactory.getInstance().getConverter(ProductEntity.class,
                        ProductDTO.class);
        ProductEntity product = productConverter.convert(dto.getProduct());
        salesItem.setProduct(product);
        return salesItem;
    }

    @Override
    public SalesItemDTO convert(final SalesItem entity) {
        SalesItemDTO salesItemDTO = new SalesItemDTO();
        salesItemDTO.setTotalPrice(entity.getPrice());
        salesItemDTO.setCount(entity.getCount());
        salesItemDTO.setId(entity.getId());

        Converter<ProductEntity, ProductDTO> productConverter =
                ConverterFactory.getInstance().getConverter(ProductEntity.class,
                        ProductDTO.class);
        ProductDTO productDTO = productConverter.convert(entity.getProduct());
        salesItemDTO.setProduct(productDTO);
        return salesItemDTO;
    }
}
