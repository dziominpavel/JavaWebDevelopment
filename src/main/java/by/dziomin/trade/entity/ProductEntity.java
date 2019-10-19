package by.dziomin.trade.entity;

import java.math.BigDecimal;

/**
 * Product entity
 *
 * @author - Pavel Dziomin
 */
public class ProductEntity extends BaseEntity {
    private String name;
    private String barcode;
    private BigDecimal price;
    private Integer count;
    private MeasureEntity measure;

    /**
     * Get product measure
     *
     * @return measure
     */
    public MeasureEntity getMeasure() {
        return measure;
    }

    /**
     * Set product measure
     *
     * @param measure measure
     */
    public void setMeasure(final MeasureEntity measure) {
        this.measure = measure;
    }

    /**
     * Get product name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set product name
     *
     * @param name name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get product barcode
     *
     * @return product barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Set product barcode
     *
     * @param barcode barcode to set
     */
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }

    /**
     * Get product price
     *
     * @return product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Set product price
     *
     * @param price price to set
     */
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    /**
     * Get product count in stock
     *
     * @return count in stock
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Set product count in stock
     *
     * @param count count to set
     */
    public void setCount(final Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProductEntity))
            return false;

        ProductEntity product = (ProductEntity) o;

        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null)
            return false;
        if (getBarcode() != null ? !getBarcode().equals(product.getBarcode()) : product.getBarcode() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(product.getPrice()) : product.getPrice() != null)
            return false;
        return getCount() != null ? getCount().equals(product.getCount()) : product.getCount() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getBarcode() != null ? getBarcode().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCount() != null ? getCount().hashCode() : 0);
        result = 31 * result + (getMeasure() != null ? getMeasure().hashCode() : 0);
        return result;
    }
}
