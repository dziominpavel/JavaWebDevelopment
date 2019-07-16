package by.dziomin.task1.specification;

import by.dziomin.task1.entity.Voucher;
import by.dziomin.task1.entity.VoucherType;

import java.util.function.Predicate;

public class VoucherFindByType implements IFindSpecification {
    /**
     * getPredicate.
     * @param object object.
     * @return Predicate<Voucher>
     */
    @Override
    public Predicate<Voucher> getPredicate(final Object object) {
        VoucherType type = (VoucherType) object;
        return v -> v.getVoucherType().equals(type);
    }
}
