package by.dziomin.trade.entity;

import java.math.BigDecimal;

public class Product extends BaseEntity {
    private String name;
    private String barcode;
    private BigDecimal price;
    private Integer count;
    private Measure measure;

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(final Measure measure) {
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;

        Product product = (Product) o;

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
