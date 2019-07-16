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
    public RelaxType getRelaxType() {
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
                + ", relaxType=" + getRelaxType()
                + '}';
    }

}
