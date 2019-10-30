package by.dziomin.trade.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Receipt entity
 *
 * @author - Pavel Dziomin
 */
public class ReceiptEntity extends BaseEntity {
    private BigDecimal totalPrice;
    private LocalDateTime date;
    private UserEntity user;
    private List<SalesItem> salesItems;

    /**
     * Get total gross amount
     *
     * @return total gross amount
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Set total gross amount
     *
     * @param totalPrice total gross amount
     */
    public void setTotalPrice(final BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Get receipt date
     *
     * @return receipt date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Set receipt date
     *
     * @param date date to set
     */
    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    /**
     * Get receipt cashier
     *
     * @return receipt cashier
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Set receipt cashier
     *
     * @param user cashier to set
     */
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    /**
     * Get receipt sales items
     *
     * @return sales items list
     */
    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    /**
     * Set receipt sales items
     *
     * @param salesItems sales items to set
     */
    public void setSalesItems(final List<SalesItem> salesItems) {
        this.salesItems = salesItems;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ReceiptEntity receipt = (ReceiptEntity) o;

        if (getTotalPrice() != null ? !getTotalPrice().equals(receipt.getTotalPrice()) : receipt.getTotalPrice() != null)
            return false;
        if (getDate() != null ? !getDate().equals(receipt.getDate()) : receipt.getDate() != null)
            return false;
        return getUser() != null ? getUser().equals(receipt.getUser()) : receipt.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getTotalPrice() != null ? getTotalPrice().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }
}
