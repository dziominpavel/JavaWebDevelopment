package by.dziomin.task1.specification;


import by.dziomin.task1.entity.Voucher;

import java.util.function.Predicate;

public class VoucherFindByDestination implements IFindSpecification {
    /**
     * getPredicate.
     *
     * @param object object.
     * @return Predicate<Voucher>
     */
    @Override
    public Predicate<Voucher> getPredicate(final Object object) {
        String destination = (String) object;
        return v -> v.getDestinationCountry().equals(destination);
    }
}
