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
    private String getWorkName() {
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
     * equals.
     *
     * @param newO newObject.
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

        WorkingVoucher that = (WorkingVoucher) newO;

        return getWorkName() != null ? getWorkName()
                .equals(that.getWorkName()) : that.getWorkName() == null;
    }

    /**
     * hashCode.
     *
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int magicNumber = 31;
        result = magicNumber * result + (getWorkName() != null
                ? getWorkName().hashCode() : 0);
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
                + ", workName=" + getWorkName()
                + '}';
    }

}
