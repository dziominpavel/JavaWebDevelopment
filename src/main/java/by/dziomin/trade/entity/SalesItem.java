package by.dziomin.trade.entity;

import java.math.BigDecimal;

public class SalesItem extends BaseEntity {
    private ReceiptEntity receipt;
    private ProductEntity product;
    private Integer count;
    private BigDecimal price;

    public ReceiptEntity getReceipt() {
        return receipt;
    }

    public void setReceipt(final ReceiptEntity receipt) {
        this.receipt = receipt;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(final ProductEntity product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SalesItem salesItem = (SalesItem) o;

        if (getReceipt() != null ? !getReceipt().equals(salesItem.getReceipt()) : salesItem.getReceipt() != null)
            return false;
        if (getProduct() != null ? !getProduct().equals(salesItem.getProduct()) : salesItem.getProduct() != null)
            return false;
        if (getCount() != null ? !getCount().equals(salesItem.getCount()) : salesItem.getCount() != null)
            return false;
        return getPrice() != null ? getPrice().equals(salesItem.getPrice()) : salesItem.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getReceipt() != null ? getReceipt().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
        result = 31 * result + (getCount() != null ? getCount().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }
}
