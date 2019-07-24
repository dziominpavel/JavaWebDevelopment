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
    private String getShopName() {
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
     * equals.
     *
     * @param newO newObject
     * @return boolean
     */
    @Override
    public boolean equals(final Object newO) {
        if (this == newO) {
            return true;
        }
        if (newO == null || getClass() != newO.getClass()) {
            return false;
        }
        if (!super.equals(newO)) {
            return false;
        }

        ShoppingVoucher that = (ShoppingVoucher) newO;

        return getShopName() != null ? getShopName()
                .equals(that.getShopName())
                : that.getShopName() == null;
    }

    /**
     * hashCode.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int magicNumber = 31;
        result = magicNumber * result + (getShopName() != null
                ? getShopName().hashCode() : 0);
        return result;
    }

    /**
     * tostring midication voucher.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "\nVoucher{"
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
