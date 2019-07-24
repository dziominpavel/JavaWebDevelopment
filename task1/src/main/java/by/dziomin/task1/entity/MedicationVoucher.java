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
    private String getHospitalName() {
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
     * equals.
     *
     * @param newO newObject.
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

        MedicationVoucher that = (MedicationVoucher) newO;

        return getHospitalName() != null ? getHospitalName()
                .equals(that.getHospitalName())
                : that.getHospitalName() == null;
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
        result = magicNumber * result
                + (getHospitalName() != null
                ? getHospitalName().hashCode() : 0);
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
                + ", hospitalName=" + getHospitalName()
                + '}';
    }
}
