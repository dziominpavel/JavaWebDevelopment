package by.dziomin.trade.dto.salesitem;

import by.dziomin.trade.dto.BaseDTO;
import by.dziomin.trade.dto.product.ProductDTO;

import java.math.BigDecimal;

public class SalesItemDTO extends BaseDTO {
    private ProductDTO product;
    private Integer count;
    private BigDecimal totalPrice;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(final ProductDTO product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
