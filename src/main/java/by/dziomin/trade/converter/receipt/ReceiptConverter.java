package by.dziomin.trade.converter.receipt;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.entity.Receipt;
import by.dziomin.trade.entity.SalesItem;
import by.dziomin.trade.entity.User;

import java.util.Date;
import java.util.List;

public class ReceiptConverter extends BaseConverter<Receipt, ReceiptCreateDTO> {
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
    public Receipt convert(final ReceiptCreateDTO dto) {
        Receipt receipt = new Receipt();
        receipt.setAmount(dto.getTotalPrice());
        receipt.setDate(new Date());

        Converter<User, SessionUserDTO> userConverter =
                ConverterFactory.getInstance().getConverter(User.class, SessionUserDTO.class);
        User user = userConverter.convert(dto.getCurrentUser());
        receipt.setUser(user);

        Converter<SalesItem, SalesItemDTO> salesItemConverter =
                ConverterFactory.getInstance().getConverter(SalesItem.class,
                        SalesItemDTO.class);
        List<SalesItem> salesItems =
                salesItemConverter.convertDtoList(dto.getSalesItems());
        receipt.setSalesItems(salesItems);

        return receipt;
    }
}
