package by.dziomin.task1.specification;

import by.dziomin.task1.entity.Voucher;

import java.util.function.Predicate;

public class VoucherFindByDeparture implements IFindSpecification {
    /**
     * getPredicate.
     * @param object object.
     * @return Predicate<Voucher>
     */
    @Override
    public Predicate<Voucher> getPredicate(final Object object) {
        String departure = (String) object;
        return v -> v.getDepartureCountry().equals(departure);
    }
}
