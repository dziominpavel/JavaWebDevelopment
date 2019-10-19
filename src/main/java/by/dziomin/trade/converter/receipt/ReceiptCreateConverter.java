package by.dziomin.trade.converter.receipt;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.SalesItem;

import java.time.LocalDateTime;
import java.util.List;

public class ReceiptCreateConverter extends BaseConverter<ReceiptEntity, ReceiptCreateDTO> {
    private static ReceiptCreateConverter instance;

    private ReceiptCreateConverter() {
    }

    public static ReceiptCreateConverter getInstance() {
        if (instance == null) {
            instance = new ReceiptCreateConverter();
        }
        return instance;
    }

    @Override
    public ReceiptEntity convert(final ReceiptCreateDTO dto) {

        ReceiptEntity receipt = new ReceiptEntity();
        receipt.setAmount(dto.getTotalPrice());
        receipt.setDate(LocalDateTime.now());


        Converter<SalesItem, SalesItemDTO> salesItemConverter =
                ConverterFactory.getInstance().getConverter(SalesItem.class,
                        SalesItemDTO.class);
        List<SalesItem> salesItems =
                salesItemConverter.convertDtoList(dto.getSalesItems());
        receipt.setSalesItems(salesItems);

        return receipt;
    }
}
