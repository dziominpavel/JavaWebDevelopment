package by.dziomin.trade.dto.receipt;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.dto.salesitem.SalesItemDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO to display receipt
 *
 * @author - Pavel Dziomin
 */
public class ReceiptDTO extends BaseDTO {
    private List<SalesItemDTO> salesItems;
    private BigDecimal totalPrice;
    private String userName;
    private LocalDateTime date;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
}
