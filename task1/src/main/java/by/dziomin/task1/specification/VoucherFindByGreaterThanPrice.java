package by.dziomin.task1.specification;

import by.dziomin.task1.entity.Voucher;

import java.util.function.Predicate;

public class VoucherFindByGreaterThanPrice implements IFindSpecification {
    /**
     * getPredicate.
     * @param object object.
     * @return Predicate<Voucher>
     */
    @Override
    public Predicate<Voucher> getPredicate(final Object object) {
        Double price = (Double) object;
        return v -> v.getPrice() > price;
    }
}
