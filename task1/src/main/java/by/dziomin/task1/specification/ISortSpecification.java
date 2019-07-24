package by.dziomin.task1.specification;

import by.dziomin.task1.entity.Voucher;

import java.util.Comparator;

public interface ISortSpecification<T extends Voucher>
        extends ISpecification {
    /**
     * @return getComparator.
     */
    Comparator<T> getComparator();
}
