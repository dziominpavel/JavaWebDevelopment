package by.dziomin.trade.converter.receipt;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.SalesItem;

import java.util.List;

/**
 * Converter for ReceiptEntity and ReceiptDTO
 *
 * @author - Pavel Dziomin
 */
public class ReceiptConverter extends BaseConverter<ReceiptEntity, ReceiptDTO> {
    private static ReceiptConverter instance;

    private ReceiptConverter() {
    }

    public static ReceiptConverter getInstance() {
        if (instance == null) {
            instance = new ReceiptConverter();
        }
        return instance;
    }

    @Override
    public ReceiptDTO convert(final ReceiptEntity receiptEntity) {
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setId(receiptEntity.getId());
        receiptDTO.setUserName(receiptEntity.getUser().getName());
        receiptDTO.setDate(receiptEntity.getDate());
        receiptDTO.setTotalPrice(receiptEntity.getTotalPrice());

        List<SalesItem> salesItems = receiptEntity.getSalesItems();
        if (salesItems != null && !salesItems.isEmpty()) {
            Converter<SalesItem, SalesItemDTO> converter =
                    ConverterFactory.getInstance().getConverter(SalesItem.class, SalesItemDTO.class);
            List<SalesItemDTO> salesItemDTOs =
                    converter.convertEntityList(salesItems);
            receiptDTO.setSalesItems(salesItemDTOs);
        }
        return receiptDTO;
    }
}
