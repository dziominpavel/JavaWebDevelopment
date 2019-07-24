package by.dziomin.task1.entity;


import java.util.Observable;

import static by.dziomin.task1.service.VoucherValidator.countDaysValidator;
import static by.dziomin.task1.service.VoucherValidator.departureCountryValidator;
import static by.dziomin.task1.service.VoucherValidator.destinationCountryValidator;
import static by.dziomin.task1.service.VoucherValidator.eatingTypeValidator;
import static by.dziomin.task1.service.VoucherValidator.priceValidator;
import static by.dziomin.task1.service.VoucherValidator.transportTypeValidator;
import static by.dziomin.task1.service.VoucherValidator.voucherTypeValidator;

public abstract class Voucher extends Observable {
    /**
     * vouchertype.
     */
    private VoucherType voucherType = VoucherType.UNKNOWN;
    /**
     * departure country.
     */
    private String departureCountry = "Unknown";
    /**
     * destination country.
     */
    private String destinationCountry = "Unknown";
    /**
     * price.
     */
    private double price = 0;
    /**
     * transport.
     */
    private TransportType transportType = TransportType.UNKNOWN;
    /**
     * count of days.
     */
    private int countDays = 0;
    /**
     * type of eating.
     */
    private EatingType eatingType = EatingType.UNKNOWN;

    /**
     * getter method for voucherType field.
     *
     * @return voucherType.
     */
    public VoucherType getVoucherType() {
        return voucherType;
    }


    /**
     * setter method for voucherType field.
     *
     * @param newVoucherType newVoucherType.
     */
    public void setVoucherType(final VoucherType newVoucherType) {
        if (voucherTypeValidator(String.valueOf(newVoucherType))) {
            voucherType = newVoucherType;
        }
    }

    /**
     * getter method for departureCountry field.
     *
     * @return departureCountry.
     */
    public String getDepartureCountry() {
        return departureCountry;
    }

    /**
     * setter method for departureCountry field.
     *
     * @param newDepartureCountry newDepartureCountry.
     */
    public void setDepartureCountry(final String newDepartureCountry) {
        if (departureCountryValidator(newDepartureCountry)) {
            departureCountry = newDepartureCountry;
        }
    }

    /**
     * getter method for destinationCountry field.
     *
     * @return destinationCountry.
     */
    public String getDestinationCountry() {
        return destinationCountry;
    }

    /**
     * setter method for destinationCountry field.
     *
     * @param newDestinationCountry newDestinationCountry.
     */
    public void setDestinationCountry(final String newDestinationCountry) {
        if (destinationCountryValidator(newDestinationCountry)) {
            destinationCountry = newDestinationCountry;
        }
    }

    /**
     * getter method for price field.
     *
     * @return price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter method for price field.
     *
     * @param newPrice newPrice.
     */
    public void setPrice(final double newPrice) {
        if (priceValidator(String.valueOf(newPrice))) {
            setChanged();
            notifyObservers(newPrice);
            price = newPrice;
        }
    }

    /**
     * getter method for transportType field.
     *
     * @return transportType.
     */
    TransportType getTransportType() {
        return transportType;
    }

    /**
     * setter method for transportType field.
     *
     * @param newTransportType newTransportType.
     */
    public void setTransportType(final TransportType newTransportType) {
        if (transportTypeValidator(String.valueOf(newTransportType))) {
            transportType = newTransportType;
        }
    }

    /**
     * getter method for countDays field.
     *
     * @return countDays.
     */
    public int getCountDays() {
        return countDays;
    }

    /**
     * setter method for countDays field.
     *
     * @param newCountDays newCountDays.
     */
    public void setCountDays(final int newCountDays) {
        if (countDaysValidator(String.valueOf(newCountDays))) {
            countDays = newCountDays;
        }
    }

    /**
     * getter method for eatingType field.
     *
     * @return eatingType.
     */
    EatingType getEatingType() {
        return eatingType;
    }

    /**
     * setter method for eatingType field.
     *
     * @param newEatingType newEatingType.
     */
    public void setEatingType(final EatingType newEatingType) {
        if (eatingTypeValidator(String.valueOf(newEatingType))) {
            eatingType = newEatingType;
        }
    }

    /**
     * equals method.
     *
     * @param obj newEatingType.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Voucher voucher = (Voucher) obj;

        if (getPrice() != voucher.getPrice()) {
            return false;
        }
        if (getVoucherType() != voucher.getVoucherType()) {
            return false;
        }
        if (getCountDays() != voucher.getCountDays()) {
            return false;
        }
        if (!getDepartureCountry().equals(voucher.getDepartureCountry())) {
            return false;
        }

        if (!getDestinationCountry().equals(voucher.getDestinationCountry())) {
            return false;
        }
        if (getTransportType() != voucher.getTransportType()) {
            return false;
        }
        return getEatingType() == voucher.getEatingType();
    }

    /**
     * hashCode method.
     */
    @Override
    public int hashCode() {
        int result = getDepartureCountry().hashCode();
        result = result + getVoucherType().hashCode();
        result = result + getDestinationCountry().hashCode();
        result = result + (int) (getPrice());
        result = result + getTransportType().hashCode();
        result = result + getCountDays();
        result = result + getEatingType().hashCode();
        return result;
    }

    /**
     * vousher to string.
     *
     * @return String.
     */

    @Override
    public String toString() {
        return "Voucher{"
                + "voucherType='" + voucherType + '\''
                + "departureCountry='" + departureCountry + '\''
                + ", destinationCountry='" + destinationCountry + '\''
                + ", price=" + price
                + ", transportType=" + transportType
                + ", countDays=" + countDays
                + ", eatingType=" + eatingType
                + '}';
    }


}
