package by.dziomin.task1.entity;

import static by.dziomin.task1.service.VoucherValidator.hospitalNameValidator;

public class WorkingVoucher extends Voucher {
    /**
     * workName.
     */
    private String workName = "Unknown";

    /**
     * getter method for workName field.
     *
     * @return workName.
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * setter method for workName field.
     *
     * @param newWorkName newWorkName.
     */
    public void setWorkName(final String newWorkName) {
        if (hospitalNameValidator(newWorkName)) {
            workName = newWorkName;
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
                + ", workName=" + getWorkName()
                + '}';
    }

}
