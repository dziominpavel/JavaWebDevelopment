package by.dziomin.task1.entity;

import static by.dziomin.task1.service.VoucherValidator.hospitalNameValidator;

public class ShoppingVoucher extends Voucher {
    /**
     * shopName.
     */
    private String shopName = "Unknown";

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
        if (hospitalNameValidator(newShopName)) {
            shopName = newShopName;
        }
    }

    /**
     * tostring midication voucher.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Voucher{"
                + "voucherType='" + getVoucherType() + '\''
                + "departureCountry='" + getDepartureCountry() + '\''
                + ", destinationCountry='" + getDestinationCountry()
                + '\''
                + ", price=" + getPrice()
                + ", transportType=" + getTransportType()
                + ", countDays=" + getCountDays()
                + ", eatingType=" + getEatingType()
                + ", shopName=" + getShopName()
                + '}';
    }
}
