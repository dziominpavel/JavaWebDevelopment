package by.dziomin.task1.entity;

public abstract class Voucher {
    /**
     * departure country.
     */
    private String departureCountry;
    /**
     * destination country.
     */
    private String destinationCountry;
    /**
     * price.
     */
    private long price;
    /**
     * transport.
     */
    private TransportType transportType;
    /**
     * count of days.
     */
    private int countDays;


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
        departureCountry = newDepartureCountry;
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
        destinationCountry = newDestinationCountry;
    }

    /**
     * getter method for price field.
     *
     * @return price.
     */
    public long getPrice() {
        return price;
    }

    /**
     * setter method for price field.
     *
     * @param newPrice newPrice.
     */
    public void setPrice(final long newPrice) {
        price = newPrice;
    }

    /**
     * getter method for transportType field.
     *
     * @return transportType.
     */
    public TransportType getTransportType() {
        return transportType;
    }
    /**
     * setter method for transportType field.
     *
     * @param newTransportType newTransportType.
     */
    public void setTransportType(final TransportType newTransportType) {
        transportType = newTransportType;
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
        countDays = newCountDays;
    }
}
