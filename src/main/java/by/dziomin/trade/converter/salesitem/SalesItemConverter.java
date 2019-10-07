package by.dziomin.trade.converter.salesitem;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.product.ProductDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.Product;
import by.dziomin.trade.entity.SalesItem;

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

        Converter<Product, ProductDTO> productConverter =
                ConverterFactory.getInstance().getConverter(Product.class,
                        ProductDTO.class);
        Product product = productConverter.convert(dto.getProduct());
        salesItem.setProduct(product);
        return salesItem;
    }
}
