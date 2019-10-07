package by.dziomin.trade.dto.receipt;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptDTO extends BaseDTO {
    private List<SalesItemDTO> salesItems;
    private BigDecimal totalPrice;

    public List<SalesItemDTO> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(final List<SalesItemDTO> salesItems) {
        this.salesItems = salesItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
