package by.dziomin.task1.factory;

import by.dziomin.task1.entity.MedicationVoucher;
import by.dziomin.task1.entity.RelaxVoucher;
import by.dziomin.task1.entity.ShoppingVoucher;
import by.dziomin.task1.entity.Voucher;
import by.dziomin.task1.entity.VoucherType;
import by.dziomin.task1.entity.WorkingVoucher;
import by.dziomin.task1.exception.IllegalVoucherArgumentException;

public class VoucherFactory {
    /**
     * Factory method creates Voucher with concrete type.
     *
     * @param voucherType type for create concrete Voucher.
     * @return concrete Voucher.
     * @throws IllegalVoucherArgumentException illegal argument.
     */

    public Voucher createVoucher(final VoucherType voucherType)
            throws IllegalVoucherArgumentException {
        if (voucherType == null) {
            throw new IllegalArgumentException();
        }

        switch (voucherType) {
            case RELAX:
                return new RelaxVoucher();
            case MEDICATION:
                return new MedicationVoucher();
            case SHOPPING:
                return new ShoppingVoucher();
            case WORKING:
                return new WorkingVoucher();

            default:
                throw new IllegalArgumentException();
        }
    }

}
