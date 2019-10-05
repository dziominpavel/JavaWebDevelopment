package by.dziomin.trade.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Receipt extends BaseEntity {
    private BigDecimal amount;
    private Date date;
    private User user;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }


    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Receipt receipt = (Receipt) o;

        if (getAmount() != null ? !getAmount().equals(receipt.getAmount()) : receipt.getAmount() != null)
            return false;
        if (getDate() != null ? !getDate().equals(receipt.getDate()) : receipt.getDate() != null)
            return false;
        return getUser() != null ? getUser().equals(receipt.getUser()) : receipt.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getAmount() != null ? getAmount().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }
}
