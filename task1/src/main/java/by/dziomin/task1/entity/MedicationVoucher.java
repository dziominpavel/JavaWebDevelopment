package by.dziomin.task1.entity;

public class MedicationVoucher extends Voucher {
    /**
     * hospitalName.
     */
    private String hospitalName;
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
        hospitalName = newHospitalName;
    }
}
