package by.dziomin.task1.entity;

public class RelaxVoucher extends Voucher {
    /**
     * relaxType.
     */
    private RelaxType relaxType;

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
        relaxType = newRelaxType;
    }
}
