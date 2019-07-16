package by.dziomin.task1.specification;

import by.dziomin.task1.entity.Voucher;

import java.util.Comparator;

public final class VoucherSortByPriceSpecification
        implements ISortSpecification {

    @Override
    public Comparator<Voucher> getComparator() {
        return Comparator.comparing(Voucher::getPrice);
    }

}
