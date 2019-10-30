package by.dziomin.trade.converter.receipt;

import by.dziomin.trade.converter.BaseConverter;
import by.dziomin.trade.converter.Converter;
import by.dziomin.trade.converter.ConverterFactory;
import by.dziomin.trade.dto.receipt.ReceiptCreateDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;
import by.dziomin.trade.dto.user.SessionUserDTO;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.SalesItem;
import by.dziomin.trade.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Converter for ReceiptEntity and ReceiptCreateDTO
 *
 * @author - Pavel Dziomin
 */
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
        receipt.setTotalPrice(dto.getTotalPrice());
        receipt.setDate(LocalDateTime.now());


        Converter<SalesItem, SalesItemDTO> salesItemConverter =
                ConverterFactory.getInstance().getConverter(SalesItem.class,
                        SalesItemDTO.class);
        List<SalesItem> salesItems =
                salesItemConverter.convertDtoList(dto.getSalesItems());
        receipt.setSalesItems(salesItems);

        Converter<UserEntity, SessionUserDTO> userConverter =
                ConverterFactory.getInstance().getConverter(UserEntity.class,
                        SessionUserDTO.class);
        UserEntity userEntity = userConverter.convert(dto.getCurrentUser());
        receipt.setUser(userEntity);

        return receipt;
    }
}
