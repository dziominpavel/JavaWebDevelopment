package by.dziomin.task1.service;

import by.dziomin.task1.entity.Voucher;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public final class VoucherInformer implements Observer {
    /**
     * VoucherInformer.
     */
    private static VoucherInformer instance;

    /**
     * voucherWereHouse.
     */
    private double totalPrice;

    private VoucherInformer() {
    }

    /**
     * singleton VoucherInformer.
     *
     * @return instance.
     */
    public static VoucherInformer getInstance() {

        if (instance == null) {
            instance = new VoucherInformer();
        }
        return instance;
    }

    /**
     * method calculate total price.
     *
     * @param voucherList voucherList.
     */
    public void calcTotalPrice(final List<Voucher> voucherList) {
        totalPrice = 0;
        for (Voucher voucher : voucherList) {
            voucher.addObserver(this);
            totalPrice = totalPrice + voucher.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice;
    }

    @Override
    public void update(final Observable o, final Object arg) {
        totalPrice -= ((Voucher) o).getPrice();
        totalPrice += (double) arg;
    }
}
