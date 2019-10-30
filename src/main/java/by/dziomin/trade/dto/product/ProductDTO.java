package by.dziomin.trade.dto.product;

import by.dziomin.trade.dto.BaseDTO;

import java.math.BigDecimal;

/**
 * DTO to display product
 *
 * @author - Pavel Dziomin
 */
public class ProductDTO extends BaseDTO {
    private String name;
    private String barcode;
    private BigDecimal price;
    private Integer count;
    private String measure;

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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(final String measure) {
        this.measure = measure;
    }
}
