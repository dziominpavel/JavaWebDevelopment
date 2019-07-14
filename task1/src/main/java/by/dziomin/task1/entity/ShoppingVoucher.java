package by.dziomin.task1.entity;

public class ShoppingVoucher extends Voucher {
    /**
     * shopName.
     */
    private String shopName;
    /**
     * getter method for shopName field.
     *
     * @return shopName.
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * setter method for shopName field.
     *
     * @param newShopName newShopName.
     */
    public void setShopName(final String newShopName) {
        shopName = newShopName;
    }
}
