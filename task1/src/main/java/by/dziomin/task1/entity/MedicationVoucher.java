package by.dziomin.task1.entity;

import static by.dziomin.task1.service.VoucherValidator.hospitalNameValidator;

public class MedicationVoucher extends Voucher {
    /**
     * hospitalName.
     */
    private String hospitalName = "Unknown";

    /**
     * getter method for hospitalName field.
     *
     * @return hospitalName.
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * setter method for hospitalName field.
     *
     * @param newHospitalName newHospitalName.
     */
    public void setHospitalName(final String newHospitalName) {
        if (hospitalNameValidator(newHospitalName)) {
            hospitalName = newHospitalName;
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
                + ", hospitalName=" + getHospitalName()
                + '}';
    }
}
