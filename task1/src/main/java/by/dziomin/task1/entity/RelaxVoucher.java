package by.dziomin.task1.entity;

import static by.dziomin.task1.service.VoucherValidator.relaxTypeValidator;

public class RelaxVoucher extends Voucher {
    /**
     * relaxType.
     */
    private RelaxType relaxType = RelaxType.UNKNOWN;

    /**
     * getter method for relaxType field.
     *
     * @return relaxType.
     */
    private RelaxType getRelaxType() {
        return relaxType;
    }

    /**
     * setter method for relaxType field.
     *
     * @param newRelaxType newRelaxType.
     */
    public void setRelaxType(final RelaxType newRelaxType) {
        if (relaxTypeValidator(String.valueOf(newRelaxType))) {
            relaxType = newRelaxType;
        }
    }

    /**
     * equals.
     *
     * @param newO newO.
     * @return boolean.
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

        RelaxVoucher that = (RelaxVoucher) newO;

        return getRelaxType() == that.getRelaxType();
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int magicNumber = 31;
        result = magicNumber * result
                + (getRelaxType() != null ? getRelaxType().hashCode() : 0);
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
                + ", relaxType=" + getRelaxType()
                + '}';
    }

}
