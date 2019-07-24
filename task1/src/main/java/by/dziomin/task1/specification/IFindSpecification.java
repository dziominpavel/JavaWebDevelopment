package by.dziomin.task1.specification;


import by.dziomin.task1.entity.Voucher;

import java.util.function.Predicate;

public interface IFindSpecification<T extends Voucher>
        extends ISpecification {
    /**
     * Predicate.
     *
     * @param object object.
     * @return Predicate.
     */
    Predicate<T> getPredicate(Object object);
}
