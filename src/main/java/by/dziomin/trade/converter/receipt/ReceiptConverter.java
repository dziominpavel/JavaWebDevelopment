package by.dziomin.trade.converter.receipt;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.dto.receipt.ReceiptDTO;
import by.dziomin.trade.entity.ReceiptEntity;

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
    public ReceiptDTO convert(final ReceiptEntity entity) {
        return super.convert(entity);
    }
}
