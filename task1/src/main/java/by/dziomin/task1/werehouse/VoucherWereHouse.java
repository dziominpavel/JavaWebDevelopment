package by.dziomin.task1.werehouse;

import by.dziomin.task1.entity.Voucher;

import java.util.HashSet;
import java.util.Set;

public final class VoucherWereHouse {
    /**
     * instance.
     */
    private static VoucherWereHouse instance;

    /**
     * voucherList.
     */
    private Set<Voucher> voucherList;

    private VoucherWereHouse() {
        voucherList = new HashSet<>();
    }

    /**
     * singleton voucherRepository.
     *
     * @return instance.
     */
    public static VoucherWereHouse getInstance() {
        if (instance == null) {
            instance = new VoucherWereHouse();
        }
        return instance;
    }

    /**
     * getVoucherList.
     *
     * @return Set<Voucher>
     */
    public Set<Voucher> getVoucherList() {
        return voucherList;
    }


}
